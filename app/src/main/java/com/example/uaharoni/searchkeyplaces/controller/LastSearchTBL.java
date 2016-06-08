package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LastSearchTBL extends PlacesDB{

    public LastSearchTBL(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("onCreate_PlacesTBL", "inside onCreate");
        String sqlCreateTable = "CREATE TABLE " +
                TBL_NAME_LASTSEARCH + "(" +
                COL_ID + INTEGER_TYPE + PRIMARY_KEY
                + COL_NAME + TEXT_TYPE
                + COL_IMAGE + TEXT_TYPE
                + COL_ADD_STREET + TEXT_TYPE
                + COL_ADD_BUILDING + TEXT_TYPE
                + COL_ADD_APARTMENT + TEXT_TYPE
                + COL_ADD_CITY + TEXT_TYPE
                + COL_ADD_STATE + TEXT_TYPE
                + COL_ADD_COUNTRY + TEXT_TYPE
                + COL_ADD_LAT + REAL_TYPE
                + COL_ADD_LONG + REAL_TYPE
                + ")";
        Log.d("onCreate","Running command " + sqlCreateTable);
        try {
            Log.d("onCreate","Running command " + sqlCreateTable);
            db.execSQL(sqlCreateTable);
        } catch (Exception e) {
            Log.d("onCreate_PlaceTBL", "Error creating table " + TBL_NAME_LASTSEARCH + ". " + e.getMessage());
        }
    }
        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
