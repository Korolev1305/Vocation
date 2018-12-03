package com.example.ewigkeit.vacantion10.AddData;

/**
 * Created by ewigkeit on 19/11/2018.
 */

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ewigkeit.vacantion10.App;
import com.example.ewigkeit.vacantion10.DatabaseHelper;
import com.example.ewigkeit.vacantion10.R;
import com.example.ewigkeit.vacantion10.Tables.Address;
import com.example.ewigkeit.vacantion10.Tables.Vacancy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDataVacancyActivity extends AppCompatActivity {

    @BindView(R.id.companyId_vacancy)
    EditText companyId;
    @BindView(R.id.employmenttype_vacancy)
    EditText employmentType;
    @BindView(R.id.salary)
    EditText salary;
    @BindView(R.id.conditions)
    EditText conditions;
    @BindView(R.id.vacancytypeId_vacancy)
    EditText vacancyTypeId;
    @BindView(R.id.experience)
    EditText experience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacancy);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_vacancy)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        if(databaseHelper.getVacancyDao().getVacancyEquals(Integer.parseInt(companyId.getText().toString()), Integer.parseInt(employmentType.getText().toString()), salary.getText().toString(),
                conditions.getText().toString(), conditions.getText().toString(), Integer.parseInt(vacancyTypeId.getText().toString()),
                experience.getText().toString())==null) {
            Vacancy model = new Vacancy(Integer.parseInt(companyId.getText().toString()), Integer.parseInt(employmentType.getText().toString()), salary.getText().toString(),
                    conditions.getText().toString(), conditions.getText().toString(), Integer.parseInt(vacancyTypeId.getText().toString()),
                    experience.getText().toString());
            databaseHelper.getVacancyDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Такая вакансия уже существует")
                    .setCancelable(false)
                    .setNegativeButton("Продолжить", (dialog, id) -> {
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }
}
