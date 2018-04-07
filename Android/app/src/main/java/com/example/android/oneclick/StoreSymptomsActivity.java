package com.example.android.oneclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class StoreSymptomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_symptoms);

        EditText etext = (EditText) findViewById(R.id.edit_text);
        String symptoms = etext.getText().toString();


    }
}
