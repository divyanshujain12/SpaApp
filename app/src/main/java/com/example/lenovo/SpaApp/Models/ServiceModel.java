package com.example.lenovo.SpaApp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceModel implements Parcelable{
    String category_id;
    String name;
    String image;
    String city_id;
    ArrayList<ProductModel> services;
public ServiceModel(){}
    protected ServiceModel(Parcel in) {
        category_id = in.readString();
        name = in.readString();
        image = in.readString();
        city_id = in.readString();
        services = in.createTypedArrayList(ProductModel.CREATOR);
    }

    public static final Creator<ServiceModel> CREATOR = new Creator<ServiceModel>() {
        @Override
        public ServiceModel createFromParcel(Parcel in) {
            return new ServiceModel(in);
        }

        @Override
        public ServiceModel[] newArray(int size) {
            return new ServiceModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(category_id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(city_id);
        dest.writeTypedList(services);
    }
}
