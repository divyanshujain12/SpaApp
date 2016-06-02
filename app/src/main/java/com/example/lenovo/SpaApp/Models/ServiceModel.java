package com.example.lenovo.SpaApp.Models;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceModel {
    String id;
    String name;
    String icon;
    ArrayList<ProductModel> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }
}
