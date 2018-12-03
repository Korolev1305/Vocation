package com.example.ewigkeit.vacantion10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ewigkeit.vacantion10.Tables.Address;
import com.example.ewigkeit.vacantion10.Tables.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 22/11/2018.
 */

public class RegistrationActivity extends Activity {
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.rpassword)
    EditText rpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registration_b)
    public void onRegClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        if (password.getText().toString().equals(rpassword.getText().toString())) {
            User user = new User(login.getText().toString(), email.getText().toString(), password.getText().toString());
            databaseHelper.getUserDao().insert(user);
            Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода пароля");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Пароли не совпадают")
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) -> {
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
