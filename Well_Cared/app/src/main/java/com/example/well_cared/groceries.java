package com.example.well_cared;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class groceries extends Activity {
    Button btGroceryFind2,btGroceryClear;
    TextView tvGroceryDis;
    EditText etGroceryItem;

    public void onButtongClick(View v){
        if (v.getId() == R.id.bt_grocery_find){
            Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
            openURL.setData(Uri.parse("http://www.walmart.com"));
            startActivity(openURL);
        }
    }

    public void onButtongbClick(View v) {
        if (v.getId() == R.id.bt_grocery_find2) {
            String item = etGroceryItem.getText().toString();
            tvGroceryDis.setText("Items:\t" + item );
        }
    }
    public void onButtongcClick(View v) {
        if (v.getId() == R.id.bt_grocery_clear) {
            tvGroceryDis.setText("");

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery);
        btGroceryFind2= (Button) findViewById(R.id.bt_grocery_find2);
        etGroceryItem=(EditText)findViewById(R.id.et_grocery_item);
        tvGroceryDis=(TextView)findViewById(R.id.tv_grocery_dis);
        btGroceryClear=(Button)findViewById(R.id.bt_grocery_clear);
    }
}
