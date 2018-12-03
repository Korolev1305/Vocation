package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Entity
public class VacancyType {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    public VacancyType(String description) {
        this.description = description;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
