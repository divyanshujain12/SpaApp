package com.example.lenovo.SpaApp.Models;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ProductModel {
    String product_id;
    String product_name;
    String description;
    String cost;
    String duration;

    public String getId() {
        return product_id;
    }

    public void setId(String id) {
        this.product_id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
