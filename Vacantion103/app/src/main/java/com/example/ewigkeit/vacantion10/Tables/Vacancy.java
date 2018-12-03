package com.example.ewigkeit.vacantion10.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by ewigkeit on 18/11/2018.
 */

@Entity(foreignKeys = {
        @ForeignKey(
                entity = EmploymentTree.class,
                parentColumns = "id",
                childColumns = "employmentTypeId"
        ),
        @ForeignKey(
                entity = VacancyType.class,
                parentColumns = "id",
                childColumns = "vacancyTypeId"
        ),
        @ForeignKey(
                entity = Company.class,
                parentColumns = "id",
                childColumns = "companyId"
        )
})
public class Vacancy {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int companyId;

    private int employmentTypeId;

    private String salary;

    private String conditions;

    private String requirements;

    private int vacancyTypeId;

    private String experience;

    public Vacancy(int companyId, int employmentTypeId, String salary, String conditions, String requirements, int vacancyTypeId, String experience) {
        this.companyId = companyId;
        this.employmentTypeId = employmentTypeId;
        this.salary = salary;
        this.conditions = conditions;
        this.requirements = requirements;
        this.vacancyTypeId = vacancyTypeId;
        this.experience = experience;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getEmploymentTypeId() {
        return employmentTypeId;
    }

    public String getSalary() {
        return salary;
    }

    public String getConditions() {
        return conditions;
    }

    public String getRequirements() {
        return requirements;
    }

    public int getVacancyTypeId() {
        return vacancyTypeId;
    }

    public String getExperience() {
        return experience;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
