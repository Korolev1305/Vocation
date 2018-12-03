package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.VacancyType;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface VacancyTypeDao {
    @Insert
    void insert(VacancyType vacancyType);

    @Delete
    void delete(VacancyType vacancyType);

    @Query("SELECT * FROM VacancyType")
    List<VacancyType> getAllData();

    @Query("SELECT * FROM VacancyType WHERE description LIKE :description")
    VacancyType getVacancyTypeEquals(String description);
}
