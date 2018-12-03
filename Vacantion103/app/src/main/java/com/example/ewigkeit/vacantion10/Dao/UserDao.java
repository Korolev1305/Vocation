package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.User;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User")
    List<User> getAllData();

    //пример запроса с выборкой
    //@Query("SELECT * FROM User WHERE title LIKE :title")
    //List<User> getByTitle(String title);
    @Query("SELECT * FROM User WHERE username LIKE :username AND password LIKE :password")
    User getUser(String username,String password);
}
