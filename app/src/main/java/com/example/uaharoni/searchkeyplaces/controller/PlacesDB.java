package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class PlacesDB extends SQLiteOpenHelper implements BaseColumns{

    final String DB_NAME = "places.db";
    final int DB_VER = 1;

    public PlacesDB(Context context) {
        super(context, "places.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
