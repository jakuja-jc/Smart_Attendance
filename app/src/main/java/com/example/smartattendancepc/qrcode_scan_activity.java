package com.example.smartattendancepc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class qrcode_scan_activity extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    public static TextView terima, hasilnya;
    Button scanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan_activity);


        hasilnya = findViewById(R.id.hasilScan1);
        scanQR = findViewById(R.id.qrscan);



//        Intent klikAbsen = getIntent();
//        terima.setText(klikAbsen.getStringExtra("absen"));

        scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String[] permit = {Manifest.permission.CAMERA};
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                        String[] permit = {Manifest.permission.CAMERA};
                        requestPermissions(permit, PERMISSION_CODE);
                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
                    }
                }
                else {

                        startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
                    }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case PERMISSION_CODE:{
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
                    }
                    else {
                            Toast.makeText(this, "Permission Denied...", Toast.LENGTH_SHORT).show();
                        }
                }
        }
    }
}
