package com.example.logoquiz.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.logoquiz.Common.Common;
import com.example.logoquiz.MainActivity;

import java.util.Collections;
import java.util.List;

public class gridViewSuggestAdapter extends BaseAdapter {
    private List<String> suggestSource;
    private Context context;
    private MainActivity mainActivity;

    public gridViewSuggestAdapter(List suggestSource, Context context, MainActivity mainActivity) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null){
            if (suggestSource.get(position).equals("null")){
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);

            }
            else{
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.YELLOW);
                button.setText((CharSequence) suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if correct answer contains character user selects
                        if (String.valueOf(mainActivity.answer).contains((CharSequence) suggestSource.get(position))){

                            char compare = ((CharSequence) suggestSource.get(position)).charAt(0);

                            for (int i=0;i<mainActivity.answer.length;i++){
                                if(compare == mainActivity.answer[i]){
                                    Common.user_submit_answer[i] = compare;
                                }
                            }
                            // Updating UI
                            gridViewAnswerAdapter answerAdapter = new gridViewAnswerAdapter(Common.user_submit_answer,context);
                            mainActivity.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            //Remove from suggest source
                            mainActivity.suggestSource.set(position,"null");
                            mainActivity.suggestAdapter = new gridViewSuggestAdapter(mainActivity.suggestSource,context,mainActivity);
                            mainActivity.gridViewSuggest.setAdapter(mainActivity.suggestAdapter);
                            mainActivity.suggestAdapter.notifyDataSetChanged();

                        }
                        else{
                            //Remove from suggest source
                            mainActivity.suggestSource.set(position,"null");
                            mainActivity.suggestAdapter = new gridViewSuggestAdapter(mainActivity.suggestSource,context,mainActivity);
                            mainActivity.gridViewSuggest.setAdapter(mainActivity.suggestAdapter);
                            mainActivity.suggestAdapter.notifyDataSetChanged();
                        }
                    }
                });

            }

        }
        else{
            button = (Button)convertView;
        }
        return button;

    }
}
