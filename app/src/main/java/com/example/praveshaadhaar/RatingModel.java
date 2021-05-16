package com.example.praveshaadhaar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingModel {
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_address")
    @Expose
    private String shopAddress;
    @SerializedName("shop_sanitation")
    @Expose
    private String shopSanitation;
    @SerializedName("mask_use")
    @Expose
    private String maskUse;
    @SerializedName("social_distancing")
    @Expose
    private String socialDistancing;
    @SerializedName("Recommeded")
    @Expose
    private String recommeded;

    private boolean expanded;

    public RatingModel(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopSanitation() {
        return shopSanitation;
    }

    public void setShopSanitation(String shopSanitation) {
        this.shopSanitation = shopSanitation;
    }

    public String getMaskUse() {
        return maskUse;
    }

    public void setMaskUse(String maskUse) {
        this.maskUse = maskUse;
    }

    public String getSocialDistancing() {
        return socialDistancing;
    }

    public void setSocialDistancing(String socialDistancing) {
        this.socialDistancing = socialDistancing;
    }

    public String getRecommeded() {
        return recommeded;
    }

    public void setRecommeded(String recommeded) {
        this.recommeded = recommeded;
    }
}
