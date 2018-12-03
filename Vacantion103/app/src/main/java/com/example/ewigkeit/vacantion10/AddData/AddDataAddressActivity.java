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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDataAddressActivity extends AppCompatActivity {

    @BindView(R.id.city)
    EditText city;
    @BindView(R.id.house)
    EditText house;
    @BindView(R.id.street)
    EditText street;
    @BindView(R.id.phoneNumber)
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_address)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        Address model = new Address(city.getText().toString(),
                house.getText().toString(), street.getText().toString(), phoneNumber.getText().toString());
        if(databaseHelper.getAddressDao().getAddressEquals(city.getText().toString(),street.getText().toString(),house.getText().toString(),phoneNumber.getText().toString())==null) {

            databaseHelper.getAddressDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Такой адрес уже существует")
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
