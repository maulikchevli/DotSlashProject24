package com.example.android.oneclick;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StoreSymptomsActivity extends AppCompatActivity {
    databasehelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb = new databasehelper(this);
        setContentView(R.layout.activity_store_symptoms);

        final EditText etext = (EditText) findViewById(R.id.edit_text);

        Button storeButton = (Button) findViewById(R.id.store_data);
        Button fetchButton = (Button) findViewById(R.id.get_data);
        Button clearButton = (Button) findViewById(R.id.clear_data);

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Symptoms
                /*AlertDialog.Builder builder = new AlertDialog.Builder(StoreSymptomsActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Disease info");
                builder.setMessage(symptoms);
                builder.show();*/
                boolean result;
                result=mydb.insertdata1(etext.getText().toString());
                if (result == true)


                {
                    Toast.makeText(getApplicationContext(), " Succesfully added",Toast.LENGTH_LONG).show();}
                else
                {Toast.makeText(getApplicationContext(), " Not added",Toast.LENGTH_LONG).show();}}

        });
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Symptoms
                fun1();

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Symptoms
                mydb.deleteall();
                Toast.makeText(getApplicationContext(), " Cleared Successfully",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void fun1(){
        //final EditText etext = (EditText) findViewById(R.id.edit_text);
        StringBuffer buffer = new StringBuffer();
        Cursor cursor = mydb.getalldata22();

        while (cursor.moveToNext()) {
            //Toast.makeText(getApplicationContext(), cursor.getString(0) + " " + cursor.getString(1), Toast.LENGTH_LONG).show();
            buffer.append(cursor.getString(0)+"\n");

        }
                /*TextView symptomsTextView = (TextView) findViewById(R.id.symptoms);
                symptomsTextView.setText(buffer);
                cursor.close();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(StoreSymptomsActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Symptoms info");
        builder.setMessage(buffer.toString());
        builder.show();
        cursor.close();

    }



    };

