package com.example.praveshaadhaar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingModel {

    private String shop_name;
    private String shop_address;
    private String shop_sanitization;
    private String mask_use;
    private String social_distancing;
    private String recommended;
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

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_sanitization() {
        return shop_sanitization;
    }

    public void setShop_sanitization(String shop_sanitization) {
        this.shop_sanitization = shop_sanitization;
    }

    public String getMask_use() {
        return mask_use;
    }

    public void setMask_use(String mask_use) {
        this.mask_use = mask_use;
    }

    public String getSocial_distancing() {
        return social_distancing;
    }

    public void setSocial_distancing(String social_distancing) {
        this.social_distancing = social_distancing;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }
}
