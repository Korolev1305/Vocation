package com.example.ewigkeit.vacantion10.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.vacantion10.Tables.Skills;

import java.util.List;

/**
 * Created by ewigkeit on 18/11/2018.
 */
@Dao
public interface SkillsDao {
    @Insert
    void insert(Skills skills);

    @Delete
    void delete(Skills skills);

    @Query("SELECT * FROM Skills")
    List<Skills> getAllData();

    @Query("SELECT description FROM Skills WHERE id LIKE :skillId")
    List<String> getSkill(int skillId);

    @Query("SELECT * FROM Skills WHERE description LIKE :description")
    Skills getSkillEquals(String description);
}
