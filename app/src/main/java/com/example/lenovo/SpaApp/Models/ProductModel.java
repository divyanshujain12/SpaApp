package com.example.lenovo.SpaApp.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ProductModel implements Parcelable{
    String id;
    String category_id;
    String city_id;
    String title;
    String description;
    String price;
    String duration;
    String image;

    public ProductModel(){}

    protected ProductModel(Parcel in) {
        id = in.readString();
        category_id = in.readString();
        city_id = in.readString();
        title = in.readString();
        description = in.readString();
        price = in.readString();
        duration = in.readString();
        image = in.readString();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getCost() {
        return price;
    }

    public void setCost(String cost) {
        this.price = cost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(category_id);
        dest.writeString(city_id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeString(duration);
        dest.writeString(image);
    }
}
