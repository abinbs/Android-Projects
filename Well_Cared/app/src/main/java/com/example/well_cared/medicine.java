package com.example.well_cared;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class medicine extends Activity {
    Button btMedicineFind2,btMedicineClear;
    TextView tvMedicineDis;
    EditText etMedicineItem;

    public void onButton6Click(View v){
        if (v.getId() == R.id.bt_medicine_find){
            Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
            openURL.setData(Uri.parse("http://www.goodrx.com"));
            startActivity(openURL);
        }
    }

    public void onButton6bClick(View v) {
        if (v.getId() == R.id.bt_medicine_find2) {
            String item = etMedicineItem.getText().toString();
            tvMedicineDis.setText("Items:\t" + item );
        }
    }
    public void onButton6cClick(View v) {
        if (v.getId() == R.id.bt_medicine_clear) {
            tvMedicineDis.setText("");

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);
        btMedicineFind2= (Button) findViewById(R.id.bt_medicine_find2);
        etMedicineItem=(EditText)findViewById(R.id.et_medicine_item);
        tvMedicineDis=(TextView)findViewById(R.id.tv_medicine_dis);
        btMedicineClear=(Button)findViewById(R.id.bt_medicine_clear);
    }
}
