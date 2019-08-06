package com.example.logoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.logoquiz.Adapter.gridViewAnswerAdapter;
import com.example.logoquiz.Adapter.gridViewSuggestAdapter;
import com.example.logoquiz.Common.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList();
    public gridViewAnswerAdapter answerAdapter;
    public gridViewSuggestAdapter suggestAdapter;

    public Button btnSummit;
    public ImageView imgViewQuestion;
    public GridView gridViewAnswer, gridViewSuggest;

    int[] image_list={

            R.drawable.android,
            R.drawable.dropbox,
            R.drawable.facebook,
            R.drawable.linkedin,
            R.drawable.pinterest,
            R.drawable.reddit,
            R.drawable.skype,
            R.drawable.snapchat,
            R.drawable.whatsapp,
            R.drawable.youtube,

    };
    public char[] answer;
    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        gridViewAnswer = (GridView)findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView)findViewById(R.id.gridViewSuggest);
        imgViewQuestion = (ImageView)findViewById(R.id.imgLogo);

        setupList();
        btnSummit = (Button)findViewById(R.id.btnSubmit);

        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                for (int i=0;i<Common.user_submit_answer.length;i++){
                    result+=String.valueOf(Common.user_submit_answer[i]);

                }
                if (result.equals(correct_answer)){
                    Toast.makeText(getApplicationContext(),"Finished! This is "+result,Toast.LENGTH_SHORT).show();
                    //Resetting


                    Common.count=0;
                    Common.user_submit_answer = new char[correct_answer.length()];

                    //Setting Adapters
                    gridViewAnswerAdapter answerAdapter = new gridViewAnswerAdapter((char[]) setupNullList(),getApplicationContext());
                    gridViewAnswer.setAdapter(answerAdapter);
                    gridViewAnswer.deferNotifyDataSetChanged();

                    gridViewSuggestAdapter suggestAdapter= new gridViewSuggestAdapter(suggestSource,getApplicationContext(),MainActivity.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    gridViewSuggest.deferNotifyDataSetChanged();
                    
                    setupList();
                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupList() {
        Random random = new Random();
        int imageselected = image_list[random.nextInt(image_list.length)];

        imgViewQuestion.setImageResource(imageselected);

        correct_answer = getResources().getResourceName(imageselected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();
        Common.user_submit_answer = new char[answer.length];

        //Adding character to list
        suggestSource.clear();
        for(char item:answer){
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //random add character to list
        for (int i=answer.length;i<answer.length*2;i++){
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);
        }
        //Sorting random
        Collections.shuffle(suggestSource);
        //Setting for Adapter
        answerAdapter = new gridViewAnswerAdapter((char[]) setupNullList(),this);
        suggestAdapter =  new gridViewSuggestAdapter(suggestSource,this,this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewAnswer.setAdapter(answerAdapter);
        gridViewSuggest.setAdapter(suggestAdapter);
    }

    private Object setupNullList() {
        char result[] = new char[answer.length];
        for(int i=0;i<answer.length;i++){
            result[i] = ' ';
        }
        return result;
    }
}
