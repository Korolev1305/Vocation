package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Entity(foreignKeys = {
        @ForeignKey(
        entity = User.class,
        parentColumns = "id",
        childColumns = "userId"),
        @ForeignKey(
                entity = Vacancy.class,
        parentColumns="id",
        childColumns = "vacancyId")
}
)
public class Response {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    private int userId;

    private String resume;

    private int vacancyId;

    public Response(String description, int userId, String resume, int vacancyId) {
        this.description = description;
        this.userId = userId;
        this.resume = resume;
        this.vacancyId = vacancyId;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }

    public String getResume() {
        return resume;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
