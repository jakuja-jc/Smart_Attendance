package com.example.smartattendancepc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class background extends AsyncTask <String, Void, String> {


    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    String data, dataemp_id, datapwd;
    public static final String EXTRA_SELECTED_VALUE  = "emp_id";
    public static final int RESULT_CODE = 200;
    public background(Context context)
    {
        this.context = context;
    }
    Intent senddata;

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String s) {
        //dialog.setMessage(s);
        //dialog.show();
        if (s.contains("Success"))
        {
            String value = dataemp_id.toString();
            senddata = new Intent();
            senddata.setClass(context.getApplicationContext(), home_activity.class);
            senddata.putExtra("emp_id", value);
            context.startActivity(senddata);
            dialog.cancel();
        } else if (s.contains("Error"))
        {
            dialog.setMessage("Your Credential is Wrong, Try Again !!");
            dialog.show();
        }

        else
            {
                dialog.setMessage("Smoething Wrong, Please Check your Password and ID or Your Internet Connection");
                dialog.show();
            }
    }


    @Override
    protected String doInBackground(String... voids) {

        String result = "";
        String user = voids[0];
        String pass = voids[1];

//        String connstr = "http://192.168.100.13:8000/api/auth";
//        String connstr = "https://api-project.mplabs.xyz/api/employee";
        String connstr = "https://api-project.mplabs.xyz/api/auth";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            dataemp_id = URLEncoder.encode(user, "UTF-8");
            data = URLEncoder.encode("emp_id", "UTF-8") +"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("password", "UTF-8") +"="+URLEncoder.encode(pass, "UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                result += line;
            }

            reader.close();
            ips.close();
            http.disconnect();
            return result;


        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }
}
