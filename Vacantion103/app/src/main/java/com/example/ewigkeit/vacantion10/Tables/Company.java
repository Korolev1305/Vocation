package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 18/11/2018.
 */


@Entity(foreignKeys = @ForeignKey(
        entity = Address.class,
        parentColumns = "id",
        childColumns = "addressId"
))
public class Company {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private int addressId;

    private String description;

    public Company(int addressId, String description) {
        this.addressId = addressId;
        this.description = description;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
