package com.example.android.oneclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntermediateHealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_health);

        TextView storeSymptomsTextView = (TextView) findViewById(R.id.store_symptoms);
        TextView getInfoTextView = (TextView) findViewById(R.id.get_info);

        getInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(IntermediateHealthActivity.this,HealthActivity.class);
                startActivity(healthIntent);
            }
        });

        storeSymptomsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(IntermediateHealthActivity.this,StoreSymptomsActivity.class);
                startActivity(healthIntent);
            }
        });
    }
}
