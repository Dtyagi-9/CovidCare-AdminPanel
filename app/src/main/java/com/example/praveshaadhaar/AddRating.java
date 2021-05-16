package com.example.praveshaadhaar;

public class AddRating {
    private String phone_no;

    private String shop_sanitization;

    private String social_distancing;

    private String shop_name;

    private String shop_address;

    private String mask_use;

    private String recommended;

    public String getPhone_no ()
    {
        return phone_no;
    }

    public void setPhone_no (String phone_no)
    {
        this.phone_no = phone_no;
    }

    public String getShop_sanitization ()
    {
        return shop_sanitization;
    }

    public void setShop_sanitization (String shop_sanitization)
    {
        this.shop_sanitization = shop_sanitization;
    }

    public String getSocial_distancing ()
    {
        return social_distancing;
    }

    public void setSocial_distancing (String social_distancing)
    {
        this.social_distancing = social_distancing;
    }

    public String getShop_name ()
    {
        return shop_name;
    }

    public void setShop_name (String shop_name)
    {
        this.shop_name = shop_name;
    }

    public String getShop_address ()
    {
        return shop_address;
    }

    public void setShop_address (String shop_address)
    {
        this.shop_address = shop_address;
    }

    public String getMask_use ()
    {
        return mask_use;
    }

    public void setMask_use (String mask_use)
    {
        this.mask_use = mask_use;
    }

    public String getRecommended ()
    {
        return recommended;
    }

    public void setRecommended (String recommended)
    {
        this.recommended = recommended;
    }

    public AddRating(String phone_no, String shop_sanitization, String social_distancing, String shop_name, String shop_address, String mask_use, String recommended) {
        this.phone_no = phone_no;
        this.shop_sanitization = shop_sanitization;
        this.social_distancing = social_distancing;
        this.shop_name = shop_name;
        this.shop_address = shop_address;
        this.mask_use = mask_use;
        this.recommended = recommended;
    }
}
