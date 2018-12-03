package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.EmploymentTree;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface EmploymentTreeDao {
    @Insert
    void insert(EmploymentTree employmentTree);

    @Delete
    void delete(EmploymentTree employmentTree);

    @Query("SELECT * FROM EmploymentTree")
    List<EmploymentTree> getAllData();

    @Query("SELECT * FROM EmploymentTree WHERE workingRate LIKE :workingRate AND description LIKE :description")
    EmploymentTree getEmploymentTreeEquals(double workingRate, String description);
}
