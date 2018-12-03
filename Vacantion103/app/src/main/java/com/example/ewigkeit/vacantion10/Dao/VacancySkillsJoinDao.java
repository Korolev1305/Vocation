package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.VacancySkillsJoin;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface VacancySkillsJoinDao {
    @Insert
    void insert(VacancySkillsJoin vacancyType);

    @Delete
    void delete(VacancySkillsJoin vacancyType);

    @Query("SELECT * FROM VacancySkillsJoin")
    List<VacancySkillsJoin> getAllData();

    @Query("SELECT skillsId FROM VacancySkillsJoin WHERE vacancyId LIKE :vacancyId")
    List<Integer> getSkills(int vacancyId);

    @Query("SELECT * FROM VacancySkillsJoin WHERE vacancyId LIKE :vacancyId AND skillsId LIKE :skillsId")
    VacancySkillsJoin getVacancySkillsJoinEquals(int vacancyId,int skillsId);
}
