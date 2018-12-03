package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.Response;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface ResponseDao {
    @Insert
    void insert(Response response);

    @Delete
    void delete(Response response);

    @Query("SELECT * FROM Response")
    List<Response> getAllData();
}
