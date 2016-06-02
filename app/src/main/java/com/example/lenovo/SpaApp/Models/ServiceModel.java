package com.example.lenovo.SpaApp.Models;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceModel {
    String category_id;
    String category_name;
    String category_icon;
    ArrayList<ProductModel> products;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return category_name;
    }

    public void setName(String name) {
        this.category_name = name;
    }

    public String getIcon() {
        return category_icon;
    }

    public void setIcon(String icon) {
        this.category_icon = icon;
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }
}
