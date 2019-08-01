package com.example.logoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.logoquiz.Adapter.gridViewAnswerAdapter;
import com.example.logoquiz.Adapter.gridViewSuggestAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List suggestSource = new ArrayList();
    public gridViewAnswerAdapter answerAdapter;
    public gridViewSuggestAdapter suggestAdapter;

    public Button btnSummit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
