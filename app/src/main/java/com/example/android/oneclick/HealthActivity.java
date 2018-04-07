package com.example.android.oneclick;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.Buffer;

public class HealthActivity extends AppCompatActivity {
    databasehelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        mydb = new databasehelper(this);
        Button fetchDiseaseButton = (Button) findViewById(R.id.fetch_diseases);
        Button fetchSymptomsButton = (Button) findViewById(R.id.fetch_symptoms);
        fetchSymptomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Symptoms
                fun1();
            }
        });

        fetchDiseaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Symptoms
                fun2();
            }
        });

    }
    public void fun1(){
        final EditText etext = (EditText) findViewById(R.id.edit_text);
        StringBuffer buffer = new StringBuffer();
        Cursor cursor = mydb.getalldata(etext.getText().toString());
        while (cursor.moveToNext()) {
            //Toast.makeText(getApplicationContext(), cursor.getString(0) + " " + cursor.getString(1), Toast.LENGTH_LONG).show();
            buffer.append(cursor.getString(1)+"\n");

        }
                /*TextView symptomsTextView = (TextView) findViewById(R.id.symptoms);
                symptomsTextView.setText(buffer);
                cursor.close();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(HealthActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Symptoms info");
        builder.setMessage(buffer.toString());
        builder.show();
        cursor.close();

    }

    public void fun2() {
        StringBuffer buffer = new StringBuffer();
        EditText etext2 = (EditText) findViewById(R.id.edit_text2);
        Cursor cursor = mydb.getalldata2(etext2.getText().toString());
        while (cursor.moveToNext()) {
            //Toast.makeText(getApplicationContext(), cursor.getString(0) + " " + cursor.getString(1), Toast.LENGTH_LONG).show();
            buffer.append(cursor.getString(0)+"\n");

        }
                /*TextView symptomsTextView = (TextView) findViewById(R.id.symptoms);
                symptomsTextView.setText(buffer);
                cursor.close();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(HealthActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Disease info");
        builder.setMessage(buffer.toString());
        builder.show();
        cursor.close();


                /*//Diseases
                StringBuffer buffer2 = new StringBuffer();
                Cursor cursor2 = mydb.getalldata(etext2.getText().toString());
                while (cursor2.moveToNext()) {
                    //Toast.makeText(getApplicationContext(), cursor.getString(0) + " " + cursor.getString(1), Toast.LENGTH_LONG).show();
                    buffer2.append(cursor.getString(1));

                }
                TextView diseasesTextView = (TextView) findViewById(R.id.diseases);
                diseasesTextView.setText(buffer2);
                cursor.close();*/
    }
}
