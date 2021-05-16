package com.example.praveshaadhaar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("ratings")
    Call<List<RatingModel>>getratingJson();

    @POST("addratings")
    Call<AddRating> sendRating(@Body AddRating addRating);
}
