package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Entity
public class Address {


    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String city;

    private String street;

    private String house;

    private String phoneNumber;

    public Address(String city, String street, String house, String phoneNumber) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
