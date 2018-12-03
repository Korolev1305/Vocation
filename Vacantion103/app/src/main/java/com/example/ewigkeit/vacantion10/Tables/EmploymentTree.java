package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Entity
public class EmploymentTree {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    private double workingRate;

    public EmploymentTree(String description, double workingRate) {
        this.description = description;
        this.workingRate = workingRate;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getWorkingRate() {
        return workingRate;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
