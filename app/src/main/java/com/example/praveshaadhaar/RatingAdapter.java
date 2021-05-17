package com.example.praveshaadhaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {
        private List<RatingModel> ratingModelList;
        private Context context;
        private RecyclerViewClick recyclerViewClick;

    public RatingAdapter(List<RatingModel> ratingModelList, Context context, RecyclerViewClick recyclerViewClick) {
        this.ratingModelList = ratingModelList;
        this.context = context;
        this.recyclerViewClick = recyclerViewClick;
    }

    @NonNull
    @Override
    public RatingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item_layout,parent,false);
        return new RatingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingAdapter.ViewHolder holder, int position) {
        holder.shopName.setText(ratingModelList.get(position).getShop_name());
        holder.shopAddress.setText(ratingModelList.get(position).getShop_address());
        holder.socialRating.setText(String.valueOf(ratingModelList.get(position).getSocial_distancing()));
        holder.sanitRating.setText(String.valueOf(ratingModelList.get(position).getShop_sanitization()));
        holder.maskRating.setText(String.valueOf(ratingModelList.get(position).getMask_use()));
        boolean isExpanded = ratingModelList.get(position).isExpanded();
        holder.layout.setVisibility(isExpanded? View.VISIBLE:View.GONE);
    }

    @Override
    public int getItemCount() {
        return ratingModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView shopName,shopAddress,sanitRating,maskRating,socialRating;
        private RatingBar ratingBarSanit,ratingBarMask,ratingBarSocial;
        private Button confirm,cancel;
        private ImageView addRating;
        private ConstraintLayout layout;
        float sanR ,maskR,socialR;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName=itemView.findViewById(R.id.shopName);
            shopAddress = itemView.findViewById(R.id.shopAddress);
            sanitRating = itemView.findViewById(R.id.sanRating);
            maskRating  = itemView.findViewById(R.id.maskRating);
            socialRating = itemView.findViewById(R.id.socialRating);
            ratingBarSanit = itemView.findViewById(R.id.ratingBar);
            ratingBarMask = itemView.findViewById(R.id.ratingBar2);
            ratingBarSocial = itemView.findViewById(R.id.ratingBar3);
            addRating = itemView.findViewById(R.id.addRatingButton);
            confirm = itemView.findViewById(R.id.confirmButton);
            cancel = itemView.findViewById(R.id.materialButton);
            layout = itemView.findViewById(R.id.addRatingLayout);

            ratingBarSanit.setOnRatingBarChangeListener((ratingBar, v, b) -> {
                sanR = ratingBar.getRating();
            });

            ratingBarMask.setOnRatingBarChangeListener((ratingBar, v, b) -> {
              maskR = ratingBar.getRating();
            });

            ratingBarSocial.setOnRatingBarChangeListener((ratingBar, v, b) -> {
                socialR = ratingBar.getRating();
            });

            addRating.setOnClickListener(view -> {
                RatingModel ratingModel = ratingModelList.get(getAdapterPosition());
                ratingModel.setExpanded(!ratingModel.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });

            confirm.setOnClickListener(view -> {
                  if (sanR !=0.0 && maskR!=0.0 && socialR!=0.0){
                    recyclerViewClick.onItemClick(getAdapterPosition(),sanR,maskR,socialR,ratingModelList.get(getAdapterPosition()).getShop_name(),ratingModelList
                    .get(getAdapterPosition()).getShop_address());
                }
            });
            cancel.setOnClickListener(view -> {

            });
        }
    }
}
