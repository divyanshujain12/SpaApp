package com.example.lenovo.SpaApp.Models;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceModel {
    String category_id;
    String name;
    String image;
    String city_id;
    ArrayList<ProductModel> services;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return image;
    }

    public void setIcon(String icon) {
        this.image = icon;
    }

    public ArrayList<ProductModel> getProducts() {
        return services;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.services = products;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}
