package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.Vacancy;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface VacancyDao {
    @Insert
    void insert(Vacancy vacancy);

    @Delete
    void delete(Vacancy vacancy);

    @Query("SELECT * FROM Vacancy")
    List<Vacancy> getAllData();

    @Query("SELECT * FROM Vacancy WHERE companyId LIKE :companyId AND employmentTypeId LIKE :employmentTypeId AND salary LIKE :salary AND conditions LIKE :conditions" +
            " AND requirements LIKE :requirements AND vacancyTypeId LIKE :vacancyTypeId AND experience LIKE :experience")
    Vacancy getVacancyEquals(int companyId, int employmentTypeId, String salary, String conditions, String requirements, int vacancyTypeId, String experience);
}
