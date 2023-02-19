package com.company.service.command;

import com.company.entity.Disc;
import com.company.entity.Merch;

public class ChangePriceCommand {
    private int ChangePercentage;

    public ChangePriceCommand(int changePercentage, Merch merch, Disc disc) {
        ChangePercentage = changePercentage;
    }

    public void setChangePercentage(int changePercentage) {
        ChangePercentage = changePercentage;
    }


    public int getChangePercentage() {
        return ChangePercentage;

    }

    @Override
    public String toString() {
        return "ChangePriceCommand{" +
                "ChangePercentage=" + ChangePercentage ;

    }
}
