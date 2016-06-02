package com.example.lenovo.SpaApp.Utils;

import com.example.lenovo.SpaApp.Models.ProductModel;
import com.example.lenovo.SpaApp.Models.ServiceModel;

import java.util.ArrayList;

/**
 * Created by divyanshu.jain on 6/2/2016.
 */
public class SingeltonClass {

    private static SingeltonClass ourInstance = new SingeltonClass();

    public static SingeltonClass getInstance() {
        return ourInstance;
    }

    public static ArrayList<ServiceModel> serviceModelArrayList = new ArrayList<>();

    public ArrayList<ProductModel> productModels = new ArrayList<>();

    public ServiceModel serviceModel;

    private SingeltonClass() {
    }

    public ArrayList<ProductModel> getProductsArrayList(int pos) {
        serviceModel = serviceModelArrayList.get(pos);
        productModels = serviceModel.getProducts();
        return productModels;
    }
}
