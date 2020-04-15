package com.example.smartattendancepc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HM_Update_Status extends AppCompatActivity {

    Button succeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hm__update__status);

        succeed = findViewById(R.id.succeed);

        succeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HM_Update_Status.this, home_activity.class));
            }
        });
    }
}
