package com.example.smartattendancepc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Berhasil_Scan extends AppCompatActivity {

    Button confirm;
    public static TextView hassssiiilll;
    //public String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil__scan);

        confirm = findViewById(R.id.okBTN);
        hassssiiilll = findViewById(R.id.resultcode);

        Intent terimadata = getIntent();
        hassssiiilll.setText(terimadata.getStringExtra("kirimresult"));

//        final Intent kirimdata = getIntent();
//        k = kirimdata.getStringExtra("kirim");

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent kirimdatalagi = new Intent(Berhasil_Scan.this, home_activity.class);
//                kirimdatalagi.putExtra("kirim", k);
//                startActivity(kirimdatalagi);
                startActivity(new Intent(Berhasil_Scan.this, home_activity.class));
                finish();
                //onDestroy();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
