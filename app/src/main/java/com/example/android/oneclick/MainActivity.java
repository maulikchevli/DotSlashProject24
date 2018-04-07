package com.example.android.oneclick;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.database.sqlite.SQLiteDatabase.OPEN_READONLY;
import static android.database.sqlite.SQLiteDatabase.OPEN_READWRITE;
import static android.database.sqlite.SQLiteDatabase.openDatabase;

public class MainActivity extends AppCompatActivity {
    databasehelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb= new databasehelper(this);
        mydb.insertdata("ashthama","wheezing");
        TextView healthView = (TextView) findViewById(R.id.health);
        healthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(MainActivity.this,HealthActivity.class);
                startActivity(healthIntent);
                /*Cursor cursor = mydb.getalldata();
                while(cursor.moveToNext()){
                    Toast.makeText(getApplicationContext(),cursor.getString(0)+" "+ cursor.getString(1),Toast.LENGTH_LONG).show();
                }*/

            }
        });
    }
}
