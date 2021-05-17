package com.example.praveshaadhaar;

public class AddRating {
    private Long phone_no;

    private Long shop_sanitization;

    private String social_distancing;

    private String shop_name;

    private String shop_address;

    private Long mask_use;

    private String recommended;

    public AddRating(Long phone_no, Long shop_sanitization, String social_distancing, String shop_name, String shop_address, Long mask_use, String recommended) {
        this.phone_no = phone_no;
        this.shop_sanitization = shop_sanitization;
        this.social_distancing = social_distancing;
        this.shop_name = shop_name;
        this.shop_address = shop_address;
        this.mask_use = mask_use;
        this.recommended = recommended;
    }
}