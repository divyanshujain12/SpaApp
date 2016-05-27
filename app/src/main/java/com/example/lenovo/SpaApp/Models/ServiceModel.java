package com.example.lenovo.SpaApp.Models;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceModel {
    String servicename;
    String serviceImageUrl;
    ArrayList<SubServiceModel> subCategories;

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServiceImageUrl() {
        return serviceImageUrl;
    }

    public void setServiceImageUrl(String serviceImageUrl) {
        this.serviceImageUrl = serviceImageUrl;
    }

    public ArrayList<SubServiceModel> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubServiceModel> subCategories) {
        this.subCategories = subCategories;
    }
}
