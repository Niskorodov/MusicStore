package com.company.service.command;

import com.company.entity.Product;

import java.util.List;

public class ReceiveNewProductsCommand {

    private List<Product> products;

    public ReceiveNewProductsCommand(List<Product> products) {
        this.products = products;
    }

    public  List<Product> getProducts() {
        return products;
    }

}
