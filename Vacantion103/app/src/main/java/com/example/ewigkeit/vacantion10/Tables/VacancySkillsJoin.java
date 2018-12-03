package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 19/11/2018.
 */

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Vacancy.class,
                parentColumns = "id",
                childColumns = "vacancyId"
        ),
        @ForeignKey(
                entity = Skills.class,
                parentColumns = "id",
                childColumns = "skillsId"
        )
})
public class VacancySkillsJoin {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int vacancyId;

    private int skillsId;

    public VacancySkillsJoin(int vacancyId, int skillsId) {
        this.vacancyId = vacancyId;
        this.skillsId = skillsId;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public int getSkillsId() {
        return skillsId;
    }

    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
