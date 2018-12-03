package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.Address;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface AddressDao {
    @Insert
    void insert(Address address);

    @Delete
    void delete(Address address);

    @Query("SELECT * FROM Address")
    List<Address> getAllData();

    @Query("SELECT * FROM Address WHERE id LIKE :id")
    List<Address> getAddressById(int id);

    @Query("SELECT * FROM Address WHERE city LIKE :city AND street LIKE :street AND house LIKE :house AND phoneNumber LIKE :phoneNumber")
    Address getAddressEquals(String city,String house,String street, String phoneNumber);
}
