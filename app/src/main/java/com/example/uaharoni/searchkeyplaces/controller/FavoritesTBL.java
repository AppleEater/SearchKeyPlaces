package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class FavoritesTBL extends PlacesDB {

    public FavoritesTBL(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("onCreate_FavoritesTBL", "inside onCreate");
        String sqlCreateTable = "CREATE TABLE " +
                TBL_NAME_FAVORITES + "(" +
                COL_ID + INTEGER_TYPE + PRIMARY_KEY
                + COL_NAME + TEXT_TYPE
                + COL_ADD_LAT + REAL_TYPE
                + COL_ADD_LONG + REAL_TYPE
                + ")";
        try {
            db.execSQL(sqlCreateTable);
           } catch (Exception e) {
            Log.d("onCreate_FavoritesTBL", "Error creating table " + TBL_NAME_FAVORITES + ". " + e.getMessage());
            }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

}
