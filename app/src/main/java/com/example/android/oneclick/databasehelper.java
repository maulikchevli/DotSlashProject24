package com.example.android.oneclick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Deep Mistry on 07-04-2018.
 */

public class databasehelper extends SQLiteOpenHelper {

    public static final String database_name = "healthcare.db";
    public static final String table_name = "healthdata";
    public static final String col_1 = "disease";
    public static final String col_2 = "symptoms";


    public databasehelper(Context context) {
        super(context, database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + table_name + " (disease VARCHAR,symptoms VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
        //onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String disease, String symptoms) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(col_1, disease);
        contentvalues.put(col_2, symptoms);
        long result = sqLiteDatabase.insert(table_name, null, contentvalues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getalldata(String dis) {
        SQLiteDatabase sb = this.getWritableDatabase();

        //Cursor cursor = sb.rawQuery("delete from "+table_name, null);
        Cursor cursor = sb.query(table_name,new String[]{col_1,col_2},"Disease like ?",new String[]{dis},null,null,null);
        return cursor;
    }
    public Cursor delalldata() {
        SQLiteDatabase sb = this.getWritableDatabase();
        Cursor cursor = sb.rawQuery("delete from "+table_name, null);
        //Cursor cursor = sb.query(table_name,new String[]{col_1,col_2},"Disease like ?",new String[]{dis},null,null,null);
        return cursor;
    }
}
