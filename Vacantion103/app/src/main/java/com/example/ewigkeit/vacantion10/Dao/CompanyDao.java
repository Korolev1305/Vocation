package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.Company;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface CompanyDao {
    @Insert
    void insert(Company company);

    @Delete
    void delete(Company company);

    @Query("SELECT * FROM Company")
    List<Company> getAllData();

    @Query("SELECT description FROM Company WHERE id LIKE :companyId")
    String getCompany(int companyId);

    @Query("SELECT * FROM Company WHERE description LIKE :description AND addressId LIKE :addressId")
    Company getCompanyEquals(String description,int addressId);
}
