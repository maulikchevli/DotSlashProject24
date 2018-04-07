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

import static android.database.sqlite.SQLiteDatabase.OPEN_READONLY;
import static android.database.sqlite.SQLiteDatabase.OPEN_READWRITE;
import static android.database.sqlite.SQLiteDatabase.openDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydatabase = openOrCreateDatabase("healthdata",MODE_PRIVATE,null);
        openDatabase("healthdata",OPEN_READWRITE);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS healthdata(disease VARCHAR,symptoms VARCHAR);");
        mydatabase.execSQL("INSERT INTO healthdata VALUES('asthama','wheezing');");

        TextView healthView = (TextView) findViewById(R.id.health);
        healthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(MainActivity.this,HealthActivity.class);
                startActivity(healthIntent);
            }
        });
    }
}
