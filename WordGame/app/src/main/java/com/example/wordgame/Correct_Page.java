package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Correct_Page extends AppCompatActivity {

    TextView tv_textCScreen, tv_textCorrectScreen, tv_textBtn,tv_textTitle1;
    ImageView bigboss;
    Animation smalltobig;

    public void onBtnBackClick(View v){
        if (v.getId() == R.id.tv_textBtn){
            Intent i =new Intent(Correct_Page.this,MainActivity.class);
            startActivity(i);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct__page);

        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        tv_textBtn = (TextView)findViewById(R.id.tv_textBtn);
        tv_textCorrectScreen = (TextView)findViewById(R.id.tv_textCorrectScreen);
        tv_textCScreen = (TextView)findViewById(R.id.tv_textCScreen);
        tv_textTitle1 = (TextView)findViewById(R.id.textTitle1);
        bigboss = (ImageView) findViewById(R.id.bigboss);
        bigboss.startAnimation(smalltobig);


        tv_textCScreen.setTypeface(typeface);
        tv_textCorrectScreen.setTypeface(typeface);
        tv_textBtn.setTypeface(typeface);
        tv_textTitle1.setTypeface(typeface);

    }
}
