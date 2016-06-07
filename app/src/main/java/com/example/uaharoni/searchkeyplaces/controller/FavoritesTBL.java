package com.example.uaharoni.searchkeyplaces.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.uaharoni.searchkeyplaces.controller.PlacesDB;

public class FavoritesTBL extends PlacesDB {
    public FavoritesTBL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
