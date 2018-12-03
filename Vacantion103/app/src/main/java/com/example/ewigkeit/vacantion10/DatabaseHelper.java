package com.example.ewigkeit.vacantion10;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.example.ewigkeit.vacantion10.Dao.AddressDao;
import com.example.ewigkeit.vacantion10.Dao.CompanyDao;
import com.example.ewigkeit.vacantion10.Dao.EmploymentTreeDao;
import com.example.ewigkeit.vacantion10.Dao.ResponseDao;
import com.example.ewigkeit.vacantion10.Dao.SkillsDao;
import com.example.ewigkeit.vacantion10.Dao.UserDao;
import com.example.ewigkeit.vacantion10.Dao.VacancyDao;
import com.example.ewigkeit.vacantion10.Dao.VacancySkillsJoinDao;
import com.example.ewigkeit.vacantion10.Dao.VacancyTypeDao;
import com.example.ewigkeit.vacantion10.Tables.Address;
import com.example.ewigkeit.vacantion10.Tables.Company;
import com.example.ewigkeit.vacantion10.Tables.EmploymentTree;
import com.example.ewigkeit.vacantion10.Tables.Response;
import com.example.ewigkeit.vacantion10.Tables.Skills;
import com.example.ewigkeit.vacantion10.Tables.User;
import com.example.ewigkeit.vacantion10.Tables.Vacancy;
import com.example.ewigkeit.vacantion10.Tables.VacancyType;
import com.example.ewigkeit.vacantion10.Tables.VacancySkillsJoin;

/**
 * Created by ewigkeit on 19/11/2018.
 */

@Database(entities = {Address.class, Company.class, EmploymentTree.class, Response.class, Skills.class,User.class, Vacancy.class, VacancyType.class, VacancySkillsJoin.class},version = 1,exportSchema = false)
public abstract class DatabaseHelper  extends RoomDatabase {
    public abstract AddressDao getAddressDao();

    public abstract CompanyDao getCompanyDao();

    public abstract EmploymentTreeDao getEmplymentTreeDao();

    public abstract ResponseDao getResponseDao();

    public abstract SkillsDao getSkillsDao();

    public abstract UserDao getUserDao();

    public abstract VacancyDao getVacancyDao();

    public abstract VacancySkillsJoinDao getVacancySkillsJoinDao();

    public abstract VacancyTypeDao getVacancyTypeDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
