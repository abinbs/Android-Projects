package com.example.well_cared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button btMedicineFind2;
    TextView tvMedicineDis;
    EditText etMedicineItem;

    public void onButton4Click(View v) {
        if (v.getId() == R.id.bt_tour) {
            Intent i = new Intent(MainActivity.this, tour.class);
            startActivity(i);
        }
    }
    public void onButton2Click(View v) {
        if (v.getId() == R.id.bt_medicine) {
            Intent i = new Intent(MainActivity.this, medicine.class);
            startActivity(i);
        }
    }
    public void onButton3Click(View v) {
        if (v.getId() == R.id.bt_grocery) {
            Intent i = new Intent(MainActivity.this, groceries.class);
            startActivity(i);
        }
    }
    public void onButton1Click(View v) {
        if (v.getId() == R.id.bt_consult) {
            Intent i = new Intent(MainActivity.this, consult.class);
            startActivity(i);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btMedicineFind2= (Button) findViewById(R.id.bt_medicine_find2);
        etMedicineItem=(EditText)findViewById(R.id.et_medicine_item);
        tvMedicineDis=(TextView)findViewById(R.id.tv_medicine_dis);

    }
}
