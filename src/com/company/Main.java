package com.company;

import com.company.constant.MerchType;
import com.company.entity.Disc;
import com.company.entity.Merch;
import com.company.entity.Product;
import com.company.service.MusicService;
import com.company.service.command.ChangePriceCommand;
import com.company.service.command.ReceiveNewProductsCommand;
import com.company.service.command.SellItemCommand;
import com.company.service.command.SetupMerchDiscountCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Merch merch = new Merch("Sting", 100, MerchType.CAP);
        Merch merch1 = new Merch("LK", 140, MerchType.BADGE);
        Merch merch2 = new Merch("Oxy", 300, MerchType.T_SHIRT);
        Merch merch3 = new Merch("Porchy", 110, MerchType.CAP);
        Disc disc = new Disc("Sting", 30, "albom", "rock");
        Disc disc1 = new Disc("LK", 100, "albom1", "pop");
        Disc disc2 = new Disc("Oxy", 200, "albom2", "pop");
        Disc disc3 = new Disc("Porchy", 300, "albom3", "pop");

        MusicService musicService = new MusicService();
        List<Product> list = new ArrayList<>();
        list.add(merch);
        list.add(merch1);
        list.add(merch2);
        list.add(merch3);
        list.add(disc);
        list.add(disc1);
        list.add(disc2);
        list.add(disc3);

        ReceiveNewProductsCommand receiveNewProductsCommand = new ReceiveNewProductsCommand(list);
        musicService.receiveNewProducts(receiveNewProductsCommand);
        System.out.println(musicService.getAvailableDiscs());
        System.out.println(musicService.getAvailableMerch());

        System.out.println(" ");
        System.out.println("Цены на товары");
        for (Merch i : musicService.getAvailableMerch()) {
            System.out.println(i.getPrice());
        }
        for (Disc i :musicService.getAvailableDiscs()){
            System.out.println(i.getPrice());
        }

        System.out.println(" ");
        System.out.println("Цены со скидкой мерча");
        SetupMerchDiscountCommand setupMerchDiscountCommand = new SetupMerchDiscountCommand(10, MerchType.CAP);
        SetupMerchDiscountCommand setupMerchDiscountCommand2 = new SetupMerchDiscountCommand(10, MerchType.BADGE);
        SetupMerchDiscountCommand setupMerchDiscountCommand3 = new SetupMerchDiscountCommand(10, MerchType.T_SHIRT);
        musicService.setupMerchDiscount(setupMerchDiscountCommand);
        musicService.setupMerchDiscount(setupMerchDiscountCommand2);
        musicService.setupMerchDiscount(setupMerchDiscountCommand3);
        for (Merch i : musicService.getAvailableMerch()) {
            System.out.println(i.getPrice());
        }

        SellItemCommand sellItemCommand = new SellItemCommand(disc, merch1);
        musicService.sellItem(sellItemCommand);
        System.out.println(musicService.getAvailableDiscs());
        System.out.println(musicService.getAvailableMerch());
        System.out.println(" ");
        System.out.println("Цена с повышением цен на мерч");

        ChangePriceCommand changePriceCommand = new ChangePriceCommand(100, merch , disc);
        musicService.changePrice(changePriceCommand);
        for (Merch i : musicService.getAvailableMerch()) {
            System.out.println(i.getPrice());
        }
        System.out.println(" ");
        System.out.println("Цена с повышением цен на диски");
        for (Disc i :musicService.getAvailableDiscs()){
            System.out.println(i.getPrice());
        }
    }
}
