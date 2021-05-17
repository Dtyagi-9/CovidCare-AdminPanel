package com.example.praveshaadhaar;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RatingFragment extends Fragment implements RecyclerViewClick {

    ArrayList<RatingModel> ratingModel = new ArrayList<>();
    private RatingAdapter ratingAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating, container, false);
        recyclerView = view.findViewById(R.id.rv_rating);
        dialog = new ProgressDialog(getContext());
       // dialog.setMessage("Loading...");
       // dialog.show();
        getresponse();
        return view;
    }

    private void getresponse() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://majorproject4.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<RatingModel>> call = apiInterface.getratingJson();

        call.enqueue(new Callback<List<RatingModel>>() {
            @Override
            public void onResponse(Call<List<RatingModel>> call, Response<List<RatingModel>> response) {
                dialog.dismiss();
                ratingModel = new ArrayList<>(response.body());
                Log.e("tag", "" + response.body());
                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                ratingAdapter = new RatingAdapter(ratingModel, getContext(), RatingFragment.this);
                recyclerView.setAdapter(ratingAdapter);

            }

            @Override
            public void onFailure(Call<List<RatingModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT);
            }
        });
    }




    @Override
    public void onItemClick(int position, float san, float mask, float dist, String shopName, String shopAddress) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://majorproject4.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        long sanit = (long) san;
        long masks = (long ) mask;
        AddRating addRating = new AddRating(Long.parseLong("9988776655"),sanit,String.valueOf(dist),shopName,shopAddress,masks,"no");
        Call<AddRating> call = apiInterface.sendRating(addRating);
        call.enqueue(new Callback<AddRating>() {
            @Override
            public void onResponse(Call<AddRating> call, Response<AddRating> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Review added", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddRating> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("tag", "" + t.getMessage());
            }
        });
    }
}