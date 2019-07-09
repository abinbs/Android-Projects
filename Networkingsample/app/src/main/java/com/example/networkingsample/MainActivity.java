package com.example.networkingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btGo;
    EditText etUrl;
    String url="https://www.google.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tv_result);
        btGo=findViewById(R.id.bt_go);
        etUrl=findViewById(R.id.et_url);

        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url=etUrl.getText().toString();
                if(!url.isEmpty()){
                    doHttpCall();

                }
                else{
                    url="http://www.google.com";
                }
            }
        });
    }
    public void doHttpCall(){
        new HttpTasks(url).execute();

    }

    class HttpTasks extends AsyncTask{
        String url;

        HttpTasks(String url) {
            this.url = url;
        }
        @SuppressLint("SetTextI18n")
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setText("Loading");
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String line="";
            try {
                URL url= new URL(this.url);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                InputStream inputStream=connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                line=bufferedReader.readLine();
            }catch (Exception e){
                e.printStackTrace();
                line="Error Occurred";

            }

            return line;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvResult.setText((String)o);
        }
    }

}
