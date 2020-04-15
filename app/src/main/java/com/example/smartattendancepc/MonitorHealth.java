package com.example.smartattendancepc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MonitorHealth extends AppCompatActivity {

    Button gejala1, gejala2, kunjungan1, kunjungan2, publish;
    Button dialogButton;
    TextView hasil1, hasil2, hasil3, hasil4;
    String[] listItems, listItems2, listItems3, listItems4;
    boolean[] itemPilihan, itemPilihan2, itemPilihan3, itemPilihan4;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    ArrayList<Integer> mUserItems2 = new ArrayList<>();
    ArrayList<Integer> mUserItems3 = new ArrayList<>();
    ArrayList<Integer> mUserItems4 = new ArrayList<>();
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialogAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_health);

        gejala1 = (Button) findViewById(R.id.symptom);
        gejala2 = (Button) findViewById(R.id.symptom2);
        kunjungan1 = (Button) findViewById(R.id.visit);
        kunjungan2 = (Button) findViewById(R.id.visit2);
        hasil1 = (TextView) findViewById(R.id.result1);
        hasil2 = (TextView) findViewById(R.id.result2);
        hasil3 = (TextView) findViewById(R.id.result3);
        hasil4 = (TextView) findViewById(R.id.result4);
        publish = findViewById(R.id.updateBtn);




        listItems = getResources().getStringArray(R.array.pilihan_batuk);
        listItems2 = getResources().getStringArray(R.array.pilihan_batuk2);
        listItems3 = getResources().getStringArray(R.array.pilihan_visit);
        listItems4 = getResources().getStringArray(R.array.pilihan_visit2);
        itemPilihan = new boolean[listItems.length];
        itemPilihan2 = new boolean[listItems2.length];
        itemPilihan3 = new boolean[listItems3.length];
        itemPilihan4 = new boolean[listItems4.length];

        gejala1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MonitorHealth.this);
                mBuilder.setTitle(R.string.dialog_title_symptom);
                mBuilder.setMultiChoiceItems(listItems, itemPilihan, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int posisi, boolean isChecked) {
                        if (isChecked)
                        {
                            mUserItems.add(posisi);
                        }
                        else
                        {
                            mUserItems.remove((Integer.valueOf(posisi)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size();i++)
                        {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1)
                            {
                                item =item + ", ";
                            }
                        }
                        hasil1.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < itemPilihan.length; i++)
                        {
                            itemPilihan[i] = false;
                            mUserItems.clear();
                            hasil1.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();


            }
        });

        gejala2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MonitorHealth.this);
                mBuilder.setTitle(R.string.dialog_title_symptom);
                mBuilder.setMultiChoiceItems(listItems2, itemPilihan2, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int posisi, boolean isChecked) {
                        if (isChecked)
                        {
                            mUserItems2.add(posisi);
                        }
                        else
                        {
                            mUserItems2.remove((Integer.valueOf(posisi)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems2.size();i++)
                        {
                            item = item + listItems2[mUserItems2.get(i)];
                            if (i != mUserItems2.size() - 1)
                            {
                                item =item + ", ";
                            }
                        }
                        hasil3.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < itemPilihan2.length; i++)
                        {
                            itemPilihan2[i] = false;
                            mUserItems2.clear();
                            hasil3.setText("");

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();


            }
        });

        kunjungan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MonitorHealth.this);
                mBuilder.setTitle(R.string.dialog_title_visit);
                mBuilder.setMultiChoiceItems(listItems3, itemPilihan3, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int posisi, boolean isChecked) {
                        if (isChecked)
                        {
                            mUserItems3.add(posisi);
                        }
                        else
                        {
                            mUserItems3.remove((Integer.valueOf(posisi)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems3.size();i++)
                        {
                            item = item + listItems3[mUserItems3.get(i)];
                            if (i != mUserItems3.size() - 1)
                            {
                                item =item + ", ";
                            }
                        }
                        hasil2.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < itemPilihan3.length; i++)
                        {
                            itemPilihan3[i] = false;
                            mUserItems3.clear();
                            hasil2.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();


            }
        });

        kunjungan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MonitorHealth.this);
                mBuilder.setTitle(R.string.dialog_title_visit);
                mBuilder.setMultiChoiceItems(listItems4, itemPilihan4, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int posisi, boolean isChecked) {
                        if (isChecked)
                        {
                            mUserItems4.add(posisi);
                        }
                        else
                        {
                            mUserItems4.remove((Integer.valueOf(posisi)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems4.size();i++)
                        {
                            item = item + listItems4[mUserItems4.get(i)];
                            if (i != mUserItems4.size() - 1)
                            {
                                item =item + ", ";
                            }
                        }
                        hasil4.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_lable, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < itemPilihan4.length; i++)
                        {
                            itemPilihan4[i] = false;
                            mUserItems4.clear();
                            hasil4.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();


            }
        });

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hasil1.getText() == "" || hasil2.getText() == "" || hasil3.getText() == "" || hasil4.getText() == "")
                {
                    showAlertDialog(R.layout.negative_layout_dialog);
                }
                else
                    {
                        startActivity(new Intent(MonitorHealth.this, HM_Update_Status.class));
                    }
            }
        });

    }

    private void showAlertDialog (int layout)
    {
        dialogBuilder = new AlertDialog.Builder(MonitorHealth.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        dialogButton = layoutView.findViewById(R.id.btnDialog);
        dialogBuilder.setView(layoutView);
        dialogAlert = dialogBuilder.create();
        dialogAlert.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogAlert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogAlert.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dialogAlert.dismiss();
//                    startActivity(new Intent(MonitorHealth.this, MonitorHealth.class));
                    finish();
            }
        });
    }
}
