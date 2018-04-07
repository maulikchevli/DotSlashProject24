package com.example.android.oneclick;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView healthView = (TextView) findViewById(R.id.health);
        TextView emergencyView = (TextView) findViewById(R.id.emergency);
        healthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healthIntent = new Intent(MainActivity.this,HealthActivity.class);
                startActivity(healthIntent);

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
