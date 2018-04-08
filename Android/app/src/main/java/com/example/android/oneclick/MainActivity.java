package com.example.android.oneclick;

import android.support.v7.app.AppCompatActivity;

import android.Manifest;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        //Cursor cursor=mydb.delalldata();
        Cursor cursor=mydb.tempgetalldata();
        int co = cursor.getCount();
        if (co==0) {
            mydb.insertdata("Hypothyroidism", "Facial expressions become dull");
            mydb.insertdata("Hypothyroidism", "Eyelids droop");
            mydb.insertdata("Hypothyroidism", "The eyes and face become puffy");
            mydb.insertdata("Hypothyroidism", "The skin becomes coarse, dry, scaly, and thick");
            mydb.insertdata("Hypothyroidism", "Weight Gain");
            mydb.insertdata("Hypothyroidism", "Increased heart rate and blood pressure");
            mydb.insertdata("Hypothyroidism", "Hand tremors");
            mydb.insertdata("Hypothyroidism", "Nervousness and anxiety");
            mydb.insertdata("Heart Attack", "Pain in chest");
            mydb.insertdata("Heart Attack", "Faintness");
            mydb.insertdata("Heart Attack", "sudden heavy sweating");
            mydb.insertdata("Heart Attack", "nausea");
            mydb.insertdata("Osteoarthritis", "joint tenderness");
            mydb.insertdata("Osteoarthritis", "weakness and muscle wasting");
            mydb.insertdata("Osteoarthritis", "limited range of movement in joints");
            mydb.insertdata("Osteoarthritis", "a grating or crackling sound or sensation in joints");
            mydb.insertdata("Conjunctivitis", "eye redness");
            mydb.insertdata("Conjunctivitis", "a burning sensation in eyes");
            mydb.insertdata("Conjunctivitis", "a sticky coating on the eyelashes");
        }


        //Cursor cursor = mydb.getalldata();
        ImageView healthView = (ImageView) findViewById(R.id.health);
        TextView emergencyView = (TextView) findViewById(R.id.emergency);
        healthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(MainActivity.this,IntermediateHealthActivity.class);
                startActivity(healthIntent);
                /*Cursor cursor = mydb.getalldata();
                while(cursor.moveToNext()){
                    Toast.makeText(getApplicationContext(),cursor.getString(0)+" "+ cursor.getString(1),Toast.LENGTH_LONG).show();
                }*/


            }
        });
        emergencyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emergencyIntent = new Intent(MainActivity.this,EmergencyServicesActivity.class);
                startActivity(emergencyIntent);
                /*Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9033164940"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);*/
            }
        });
    }
}
