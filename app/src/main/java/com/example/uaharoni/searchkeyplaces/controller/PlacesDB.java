package com.example.uaharoni.searchkeyplaces.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
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
        //TODO: Check if need to recreate the table after deleting it
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
    public Cursor getPlaceNamesCursr(String tblName, String colSort){
     Cursor cursor=null;
        Log.d("getPlaceNamesCursr","Obtain data from " + tblName + " sorted by " + colSort);
        boolean distinct = true;
        String[] columns = {COL_ID,COL_NAME,COL_ADD_STREET,COL_ADD_BUILDING,COL_ADD_CITY};
        String selection = null;
        String[] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = colSort;
        String limit = null;
        CancellationSignal cancellationSignal = null;

        try{
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.queryWithFactory(
                    null
                    ,distinct
                    ,tblName
                    ,columns
                    ,selection
                    ,selectionArgs
                    ,groupBy
                    ,having
                    ,orderBy
                    ,limit
            );
        } catch (Exception e){
            Log.e("getPlaceNamesCursr","Failed to bring cursor. " + e.getMessage());
        }
        return cursor;
    }
    private Place parseCursorRow (Cursor cursor){
        Log.d("parseCursorRow","Parsing cursor " + cursor.toString());

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
    public long insertPlace(Place place, String tblName){
        long rowid=0;
        Log.d("insertPlace","Inserting Place " + place.getName() + " to table " + tblName);
        ContentValues updatedValues = extractPlace(place);
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            rowid = db.insert(tblName, null, updatedValues);
        } catch (Exception e) {
            Log.e("insertPlace","Error Inserting " + place.getName() + " to table " + tblName + ". " + e.getMessage());
        }
        return  rowid;
    }
    public int deletePlace(String tblName,Place place){
        int linesReturned = 0;
        long rowid = place.getId();
        String where = COL_ID;
        String[] whereArgs = {String.valueOf(rowid)};
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            linesReturned = db.delete(tblName,where,whereArgs);
        } catch (Exception e){
            Log.e("deletePlace","Error deleting place. " + e.getMessage());
        }
        return linesReturned;
    }
    private ContentValues extractPlace(Place place){
        ContentValues values = new ContentValues();
        values.put(COL_NAME, place.getName());
        values.put(COL_ADD_STREET, place.getAddress().getStreet());
        values.put(COL_ADD_APARTMENT,place.getAddress().getApartment());

        return values;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("onUpgrade_PlacesDB","inside onUpgrade");
    }
}
