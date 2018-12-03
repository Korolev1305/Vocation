package com.example.ewigkeit.vacantion10;

/**
 * Created by ewigkeit on 19/11/2018.
 */

import android.app.Application;
import android.arch.persistence.room.Room;
import com.example.ewigkeit.vacantion10.DatabaseHelper;

public class App extends Application {

    private static DatabaseHelper db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "database")
                .allowMainThreadQueries()
                .build();
    }



    public static DatabaseHelper getDatabaseInstance() {
        return db;
    }
}
