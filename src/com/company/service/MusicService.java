package com.company.service;

import com.company.constant.MerchType;
import com.company.entity.Disc;
import com.company.entity.Merch;
import com.company.service.command.ChangePriceCommand;
import com.company.service.command.ReceiveNewProductsCommand;
import com.company.service.command.SetupMerchDiscountCommand;
import com.company.service.command.SellItemCommand;

import java.util.ArrayList;
import java.util.List;

public class MusicService {

    private final List<Disc> availableDiscs = new ArrayList<>();
    private final List<Merch> availableMerch = new ArrayList<>();

    public int receiveNewProducts(ReceiveNewProductsCommand command) {
        for (int i = 0; i < command.getProducts().size(); i++) {

            if (command.getProducts().get(i) instanceof Disc) {
                availableDiscs.add((Disc) command.getProducts().get(i));
            } else {
                availableMerch.add((Merch) command.getProducts().get(i));

            }

        }
        return command.getProducts().size();
    }


    public int setupMerchDiscount(SetupMerchDiscountCommand command) {
        int count = 0;
        for (Merch merch : availableMerch) {
            if (merch.getType() == command.getType()) {
                merch.setPrice(countNewPrice(command.getDiscountPercentage(), merch.getPrice()));
                count++;
            }
        }
        return count;
    }

    public int sellItem(SellItemCommand command) {
        int soldItemsCount = 0;
        for (int i = 0; i < availableMerch.size(); i++) {
            if (compareMerch(availableMerch.get(i), command.getMerch())) {
                availableMerch.remove(i);
                soldItemsCount++;
            }
        }
        for (int i = 0; i < availableDiscs.size(); i++) {
            if (compareDisc(availableDiscs.get(i), command.getDisc())) {
                availableDiscs.remove(i);
                soldItemsCount++;
            }
        }
        return soldItemsCount;

    }

    public int changePrice(ChangePriceCommand command) {
        int allChangePriceOfProducts = 0;
        for (Merch merch : availableMerch) {
            merch.setPrice(countChangePrice(command.getChangePercentage(), merch.getPrice()));
            allChangePriceOfProducts++;
        }
        for (Disc availableDisc : availableDiscs) {
            availableDisc.setPrice(countChangePrice(command.getChangePercentage(), availableDisc.getPrice()));
            allChangePriceOfProducts++;
        }
        return allChangePriceOfProducts;
    }

    public List<Disc> getAvailableDiscs() {
        return availableDiscs;
    }

    public List<Merch> getAvailableMerch() {
        return availableMerch;
    }

    private int countChangePrice(int percentage, int changerPrice) {
        return changerPrice + (percentage * changerPrice) / 100;
    }

    private int countNewPrice(int discountPercentage, int currentPrice) {
        return currentPrice - (discountPercentage * currentPrice) / 100;
    }

    private boolean compareMerch(Merch merch1, Merch merch2) {
        return (merch1.getType() == merch2.getType() && merch1.getArtist().equals(merch2.getArtist()) && merch1.getPrice() == merch2.getPrice());
    }

    private boolean compareDisc(Disc disc1, Disc disc2) {
        return (disc1.getAlbum().equals(disc2.getAlbum()) && disc1.getArtist().equals(disc2.getArtist()) && disc1.getGenre().equals(disc2.getGenre()) && disc1.getPrice() == disc2.getPrice());
    }

}
