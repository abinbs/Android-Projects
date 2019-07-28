package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int presCount = 0;
    private int maxPresCount = 0;
    private String[] keys={"R","I","B","D","X"};
    private String textAnswer = "BIRD";
    TextView tv_textScreen, tv_textQuestion, tv_textTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keys= shuffleArray(keys);

        for (String key : keys){
            addView(((LinearLayout) findViewById(R.id.ll_layoutParent)), key, ((EditText) findViewById(R.id.et_editText)));

        }
        maxPresCount=4;
    }

    private String[] shuffleArray(String[] ar){
        Random rnd= new Random();
        for(int i= ar.length -1;i>0;i++){
            int index= rnd.nextInt(i+1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    public void addView(LinearLayout viewparent, final String text,final EditText editText){
        LinearLayout.LayoutParams linearLayoutParams = new  LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

       linearLayoutParams.rightMargin = 20;
       final TextView textView = new TextView(this);

       textView.setLayoutParams(linearLayoutParams);
       textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
       textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
       textView.setGravity(Gravity.CENTER);
       textView.setText(text);
       textView.setClickable(true);
       textView.setFocusable(true);
       textView.setTextSize(32);

        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

    }
}
