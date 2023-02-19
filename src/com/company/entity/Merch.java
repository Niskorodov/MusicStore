package com.company.entity;

import com.company.constant.MerchType;

public class Merch extends Product {

    private MerchType type;

    public Merch(String artist, int price, MerchType type) {
        super(artist, price);
        this.type = type;
    }

    public MerchType getType() {
        return type;
    }

    public void setType(MerchType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Merch{" +
                "type=" + type +
                '}';
    }
}
