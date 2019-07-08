package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                    int a=Integer.parseInt(etFirst.getText().toString());
                    int b=Integer.parseInt(etSecond.getText().toString());
                    int c=a+b;
                    tvResult.setText(String.valueOf(c));

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


}
