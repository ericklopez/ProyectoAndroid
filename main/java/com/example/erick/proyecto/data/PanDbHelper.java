package com.example.erick.proyecto.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erick on 15/11/16.
 */

public class PanDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME =  "Pan.db";

    public PanDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE " + ListaPan.PanEntry.TABLE_NAME + " ("
            + ListaPan.PanEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ListaPan.PanEntry.ID + " TEXT NOT NULL,"
            + ListaPan.PanEntry.NAME + " TEXT NOT NULL,"
            + ListaPan.PanEntry.DESCR + " TEXT NOT NULL,"
            + ListaPan.PanEntry.PRECIO + " NUMBER NOT NULL,"
            + "UNIQUE (" + ListaPan.PanEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
