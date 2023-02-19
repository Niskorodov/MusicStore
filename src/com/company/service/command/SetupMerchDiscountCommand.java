package com.company.service.command;

import com.company.constant.MerchType;


public class SetupMerchDiscountCommand {
    private int discountPercentage;
    private MerchType type;

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public MerchType getType() {
        return type;
    }

    public void setType(MerchType type) {
        this.type = type;
    }

    public SetupMerchDiscountCommand(int discountPercentage, MerchType type) {
        this.discountPercentage = discountPercentage;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SetupMerchDiscountCommand{" +
                "discountPercentage=" + discountPercentage +
                ", type=" + type +
                '}';
    }
}
