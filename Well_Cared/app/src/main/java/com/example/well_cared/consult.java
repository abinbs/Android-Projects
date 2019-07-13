package com.example.well_cared;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class consult extends Activity {

    public void onButton8Click(View v){
        if (v.getId() == R.id.bt_consult_find){
            Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
            openURL.setData(Uri.parse("http://www.mollymaid.com"));
            startActivity(openURL);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consult);
    }
}
