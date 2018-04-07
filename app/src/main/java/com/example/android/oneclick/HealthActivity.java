package com.example.android.oneclick;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final databasehelper mydb;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        mydb = new databasehelper(this);
        final EditText etext = (EditText) findViewById(R.id.edit_text);
        Button fetchDataButton = (Button) findViewById(R.id.fetch_button);

        fetchDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = mydb.getalldata(etext.getText().toString());
                while (cursor.moveToNext()) {
                    //Toast.makeText(getApplicationContext(), cursor.getString(0) + " " + cursor.getString(1), Toast.LENGTH_LONG).show();

                    TextView symptomsTextView = (TextView) findViewById(R.id.symptoms);
                    symptomsTextView.setText(cursor.getString(1));

                }
            }
        });


    }
}
