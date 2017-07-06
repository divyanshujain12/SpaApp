package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import io.realm.RealmObject;

/**
 * Created by divyanshu.jain on 6/2/2016.
 */
public class AppointmentBookingModel extends RealmObject{
    private String category_id;
    private String product_id;
    private String category_name;
    private String product_name;
    private String name;
    private String number;
    private String email_id;
    private String address;
    private String date;
    private String time;
    private String additional_notes;
    private String duration;
    private String cost;
    private String city_id;
    private String quantity;
    private String therapistType;

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdditional_notes() {
        return additional_notes;
    }

    public void setAdditional_notes(String additional_notes) {
        this.additional_notes = additional_notes;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTherapistType() {
        return therapistType;
    }

    public void setTherapistType(String therapistType) {
        this.therapistType = therapistType;
    }
}
