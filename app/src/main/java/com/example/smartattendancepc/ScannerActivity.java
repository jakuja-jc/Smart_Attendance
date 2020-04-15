package com.example.smartattendancepc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class ScannerActivity extends AppCompatActivity {

    CodeScanner codeScanner;
    CodeScannerView scannerView;
    TextView scanResult;
    Button confirm;
    public String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        scannerView = findViewById(R.id.scannerview);
        scanResult = findViewById(R.id.hasilscannan);
        confirm = findViewById(R.id.confirmed);
        final Intent kirim = getIntent();
        k = kirim.getStringExtra("kirim");

        codeScanner = new CodeScanner(this, scannerView);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        scanResult.setText(result.getText());

                        confirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (confirm.isPressed() && result.getText() == null)
                                {

                                    Toast.makeText(getApplicationContext(),"QR Code Hasn't Scan yet, try again !!", Toast.LENGTH_SHORT).show();

                                }
                                else if (confirm.isPressed() && result.getText() != null)
                                    {

                                        codeScanner.stopPreview();
                                        String l = scanResult.getText().toString();
                                        Intent kirimresult = new Intent(ScannerActivity.this, Berhasil_Scan.class);
                                        kirimresult.putExtra("kirimresult", l);
                                        startActivity(kirimresult);
//                                      startActivity(new Intent(ScannerActivity.this, Berhasil_Scan.class));

                                    }
                            }
                        });

                        //qrcode_scan_activity.hasilnya.setText(result.getText());
//                        if (result.getText() == null && confirm.isPressed() == true)
//                        {
//                            Toast.makeText(getApplicationContext(),"QR Code Hasn't Scan yet, try again !!", Toast.LENGTH_SHORT).show();
//                        } else
//                            {
//                                confirm.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//
//                                        codeScanner.stopPreview();
//                                        String l = scanResult.getText().toString();
//                                        Intent kirimresult = new Intent(ScannerActivity.this, Berhasil_Scan.class);
//                                        kirimresult.putExtra("kirimresult", l);
//                                        startActivity(kirimresult);
////                                      startActivity(new Intent(ScannerActivity.this, Berhasil_Scan.class));
//                                    }
//                                });
//                            }

                    }
                });
            }
        });


        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScanner.startPreview();
                //onBackPressed();
                //startActivity(new Intent(ScannerActivity.this, Scan_Succeed.class));
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();

    }

    @Override
    protected void onPause() {
        super.onPause();
        codeScanner.stopPreview();



    }

}
