package com.example.well_cared;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tour extends AppCompatActivity {

    Button btTourFind2,btTourClear;
    TextView tvTourDis;
    EditText etTourStart,etTorStop;

    public void onButtonaClick(View v){
        if (v.getId() == R.id.bt_tour_find){
            Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
            openURL.setData(Uri.parse("http://www.coxandking.com"));
            startActivity(openURL);
        }
    }

    public void onButtonabClick(View v) {
        if (v.getId() == R.id.bt_tour_find2) {
            String item1 = etTourStart.getText().toString();
            String item2 = etTorStop.getText().toString();
            tvTourDis.setText("Your Location:\t" + item1 + "\n Dream Destintion:\t"+ item2);
        }
    }
    public void onButtonacClick(View v) {
        if (v.getId() == R.id.bt_tour_clear) {
            tvTourDis.setText("");

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour);
        btTourFind2= (Button) findViewById(R.id.bt_tour_find2);
        etTourStart=(EditText)findViewById(R.id.et_tour_start);
        tvTourDis=(TextView)findViewById(R.id.tv_tour_dis);
        btTourClear=(Button)findViewById(R.id.bt_tour_clear);
        etTorStop=(EditText)findViewById(R.id.et_tour_stop);
    }
}
