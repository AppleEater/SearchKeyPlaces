package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class PlacesDB extends SQLiteOpenHelper implements BaseColumns{
    private static final int DB_VER = 1;
    private static final String DB_NAME = "places.db";
    public static final String TBL_NAME_LASTSEARCH = "last_search";
    public static final String TBL_NAME_FAVORITES = "favorites";


    String TEXT_TYPE = " TEXT";
    String INTEGER_TYPE = " INTEGER";
    String REAL_TYPE = " REAL";
    String DATETIME_TYPE = " DATETIME";
    String COL_NULLABLE = null;
    String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT";

    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_NAME = "name";
    public static final String COL_IMAGE = "image_uri";
    public static final String COL_ADD_LAT = "lat";
    public static final String COL_ADD_LONG = "long";
    public static final String COL_ADD_STREET = "street";
    public static final String COL_ADD_CITY = "city";
    public static final String COL_ADD_STATE = "state";
    public static final String COL_ADD_COUNTRY = "country";
    public static final String COL_ADD_BUILDING = "building";
    public static final String COL_ADD_APARTMENT = "apartment";

    // Logcat tag
    public static final String LOG = "placesDbHelper";

    public PlacesDB(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("onUpgrade_PlacesDB","inside onUpgrade");
    }
}
