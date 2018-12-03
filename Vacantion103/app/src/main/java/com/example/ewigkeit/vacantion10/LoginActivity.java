package com.example.ewigkeit.vacantion10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.ewigkeit.vacantion10.Tables.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 22/11/2018.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.login_login)
    EditText login;
    @BindView(R.id.login_password)
    EditText password;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        databaseHelper = App.getDatabaseInstance();
    }

    @OnClick(R.id.login_b)
    public void onEnterClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();

        if (databaseHelper.getUserDao().getUser(login.getText().toString(),password.getText().toString())!=null)
        {
            Intent intent = new Intent(LoginActivity.this,VacancyListActivity.class);
            startActivity(intent);
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Неправильный логин/пароль")
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

    @OnClick(R.id.registration_b_l)
    public void onRegistrationClick() {
        Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }
}
