package com.example.avikrayan.reminderforwebskitters.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashutosh on 02-12-2016.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_PATH="/data/data/com.example.avikrayan.reminderforwebskitters/databases/";
    public static final String DATABASE_NAME="OurEventDatabase.db";
    public static final int DATABASE_VERSION=1;
    private final Context context;
    private SQLiteDatabase sqLiteDatabase;

    public MyDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase myDb(){
        return null;
    }
    public synchronized void close() {
        if(sqLiteDatabase!= null)
            sqLiteDatabase.close();
        super.close();
    }

}
