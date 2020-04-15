package com.example.smartattendancepc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class home_activity extends AppCompatActivity {

    TextView hasilLogin, id_mu;
    public String k;
    ImageButton absen, healthStatus, temperatur, logout;
    public Intent login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        absen = findViewById(R.id.attendance);
        healthStatus = findViewById(R.id.health);
        temperatur = findViewById(R.id.temperature);
        logout = findViewById(R.id.logout);
        id_mu = findViewById(R.id.your_id);

        hasilLogin = findViewById(R.id.identitas_result);

        login = getIntent();
        k = login.getStringExtra("emp_id");

        LoadData();
        if (logout.isPressed()){id_mu.setText("");}

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-project.mplabs.xyz/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful())
                {
                    hasilLogin.setText("Code : " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                String m = id_mu.getText().toString();

                for (Post post : posts)
                {
                    if (post.getEmp_id().compareTo(m) == 0)
                    {
                        String content = "";
                        //content += "ID : " + post.getEmp_id() + "\n";
                        content += "Name : " + post.getName() + "\n";
                        content += "Company :" + post.getCompany() + "\n";
                        content += "Department : " + post.getDepartment() + "\n";
                        content += "Team : " + post.getTeam() + "\n";
                        content += "Plant : " + post.getPlant() + "\n\n";
                        hasilLogin.append(content);
                    }

//                    String content = "";
//                    content += "ID : " + post.getEmp_id() + "\n";
//                    content += "Name : " + post.getName() + "\n";
//                    content += "Company :" + post.getCompany() + "\n";
//                    content += "Department : " + post.getDepartment() + "\n";
//                    content += "Team : " + post.getTeam() + "\n";
//                    content += "Plant : " + post.getPlant() + "\n\n";
//                    hasilLogin.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                hasilLogin.setText("Gagal !!" + t.getMessage());
            }
        });



        absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent kirim = new Intent(home_activity.this, qrcode_scan_activity.class);
//                kirim.putExtra("kirim", k);
//                startActivity(kirim);
                startActivity(new Intent(home_activity.this, qrcode_scan_activity.class));

            }
        });

        healthStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_activity.this, MonitorHealth.class));
            }
        });

        temperatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_activity.this, Temperature_Activity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(home_activity.this);
                builder.setMessage("Are you sure you want to Log Out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                home_activity.this.finish();
                                startActivity(new Intent(home_activity.this, MainActivity.class));
//                                SharedPreferences sharedPreferences = getSharedPreferences("saveIntent", MODE_PRIVATE);
//                                sharedPreferences.edit().clear().commit();
                                DeleteDataShared();
                                finish();
                                //onStop();
                                //onDestroy();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }

    public void SaveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("saveIntent", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("emp_id", k);

        editor.apply();
    }

    public void LoadData ()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("saveIntent", MODE_PRIVATE);
        k = sharedPreferences.getString("emp_id", k);
        id_mu.setText(k);

    }

    public void DeleteDataShared ()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("saveIntent", MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        id_mu.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();

        SaveData();
    }

    //    @Override
//    protected void onPause() {
//        super.onPause();
//
//        SaveData();
//    }

    @Override
    public void finish() {
        DeleteDataShared();
    }

    @Override
    public void onBackPressed() {
    }
}
