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
import com.example.ewigkeit.vacantion10.Tables.VacancyType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDataVacancyTypeActivity extends AppCompatActivity {

    @BindView(R.id.description_vacancytype)
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacancytype);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_vacancytype)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        if (databaseHelper.getVacancyTypeDao().getVacancyTypeEquals(description.getText().toString())==null) {
            VacancyType model = new VacancyType(description.getText().toString());
            databaseHelper.getVacancyTypeDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Такой тип вакансии уже существует")
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
