package com.example.lenovo.SpaApp.Models;

import io.realm.RealmObject;

/**
 * Created by divyanshu.jain on 6/6/2016.
 */
public class UserDetailModel extends RealmObject{
    String name;
    String email;
    String phonenumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

