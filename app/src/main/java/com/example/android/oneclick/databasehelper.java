package com.example.android.oneclick;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Deep Mistry on 07-04-2018.
 */

public class databasehelper extends SQLiteOpenHelper{

    public static final String database_name="healthcare.db";
    public static final String table_name="healthdata";
    public static final String col_1="disease";
    public static final String col_2="symptoms";


    public databasehelper(Context context) {
        super(context,database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
