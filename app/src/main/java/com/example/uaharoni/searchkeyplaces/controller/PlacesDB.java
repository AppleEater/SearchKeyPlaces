package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.uaharoni.searchkeyplaces.model.Place;

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
    public void deleteTBL(String tblName){
        Log.d("deleteTBL","Deleting table " + tblName);
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sqlFormat = String.format("DROP TABLE IF EXISTS %s", tblName);
            db.execSQL(sqlFormat);
            db.close();
        } catch (Exception e) {
            Log.e("deleteTBL", "Failed to delete table " + tblName + ". " + e.getMessage());
        }
    }
    public Place getPlaceById(String tblName, long rowid){
        Place place = null;
        Log.d("getPlaceById","Opening table " + tblName + " to read row " + String.valueOf(rowid));
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {}; // null on purpose, to include all fields
        String selection = tblName + "." + COL_ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowid) };
        String sortOrder = COL_NAME + " ASC";

        Cursor singleRow = db.query(tblName,projection,selection,selectionArgs,null,null,sortOrder);

        if (singleRow.getCount()>0) {
            place = parseCursorRow(singleRow);
        } else {
            Log.e("getPlaceById", "Row " + rowid + " now found");
        }
          //     db.close();    // Closing the DB may be too angerous, as multiple services may be writing to it
        return place;
    }
    private Place parseCursorRow (Cursor cursor){

        int id_index = cursor.getColumnIndex(COL_ID);
        int id_name = cursor.getColumnIndex(COL_NAME);
        int id_image = cursor.getColumnIndexOrThrow(COL_IMAGE);
        cursor.moveToFirst();
        long placeId = cursor.getLong(id_index);
        String placeName = cursor.getString(id_name);
        Place place = new Place(placeName);
        place.setId(placeId);

        return place;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("onUpgrade_PlacesDB","inside onUpgrade");
    }
}
