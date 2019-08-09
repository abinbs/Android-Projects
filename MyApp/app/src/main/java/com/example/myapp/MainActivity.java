package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    EditText etFirst,etSecond;
    Button btPlus,btMinus,btMul,btDivide,btClear;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirst=findViewById(R.id.et_first);
        etSecond=findViewById(R.id.et_second);
        btPlus=findViewById(R.id.bt_plus);
        btMinus=findViewById(R.id.bt_minus);
        tvResult=findViewById(R.id.tv_result);
        btDivide=findViewById(R.id.bt_divide);
        btMul=findViewById(R.id.bt_mul);
        btClear=findViewById(R.id.bt_clear);

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                   // new AddTask().execute();*//*for executing doInBackground function for multithreading
                    int a=Integer.parseInt(etFirst.getText().toString());
                    int b=Integer.parseInt(etSecond.getText().toString());
                    //int c=add(a,b);
                    int c=a+b;
                    tvResult.setText(String.valueOf(c));


                   // new AddTask().execute();
                }catch (Exception e){
                    showErrorToast();

                }

            }
        });
        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a=Integer.parseInt(etFirst.getText().toString());
                    int b=Integer.parseInt(etSecond.getText().toString());
                    int c=a-b;
                    tvResult.setText(String.valueOf(c));
                }catch(Exception e){
                    showErrorToast();
                }

            }
        });

        btMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int a=Integer.parseInt(etFirst.getText().toString());
                    int b=Integer.parseInt(etSecond.getText().toString());
                    int c=a*b;
                    tvResult.setText(String.valueOf(c));

                }catch (Exception e){
                    showErrorToast();

                }

            }
        });

        btDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int a=Integer.parseInt(etFirst.getText().toString());
                    int b=Integer.parseInt(etSecond.getText().toString());
                    int c=a/b;
                    tvResult.setText(String.valueOf(c));

                }catch (Exception e){
                    showErrorToast();

                }

            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    etFirst.getText().clear();
                    etSecond.getText().clear();
                    tvResult.setText("");

                }catch (Exception e){
                    showErrorToast();

                }

            }
        });

    }
    public void showErrorToast(){
        Toast.makeText(this,"Enter the numbers",Toast.LENGTH_SHORT).show();
    }

    /*public int add(int a,int b) {
        return a + b;
    }*/

    class AddTask extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setText("Please wait");
        }



        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(300);/*Creating a delay for displaying the epoch time*/
            }catch(Exception e){

            }
            /*while(true){
                System.out.println("Hello");*/
            /*long epoch = 0;
            try {
                epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 01:00:00").getTime() / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
           // String epoch= String.valueOf(System.currentTimeMillis());
            return null;/*Time of every second from 1970 useful for finding current time and date*/
            }

        @Override
        protected void onPostExecute(Object o) {/*the epoch time is transferred as string and received as an object here*/
            super.onPostExecute(o);
            tvResult.setText((String )o);
        }
    }
    /*for working it the other threads other than main thread*/


}
