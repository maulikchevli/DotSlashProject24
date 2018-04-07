package com.example.android.oneclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        EditText etext = (EditText) findViewById(R.id.edit_text);
        Button fetchDataButton = (Button) findViewById(R.id.fetch_button);

        fetchDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*TODO*/
            }
        });


    }
}
