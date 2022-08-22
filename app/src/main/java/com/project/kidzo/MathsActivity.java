package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;

public class MathsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    RecyclerViewAdapter adapter;
    TextToSpeech t1;
    String counting = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        recyclerView = findViewById(R.id.idCourseRV);
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        // added data from arraylist to adapter class.
        adapter=new RecyclerViewAdapter(recyclerDataArrayList,this,1);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        addData();
        initTts();

    }
    private void addData(){
        for (int i=1; i<=100; i++){
            RecyclerData data = new RecyclerData();
            String data1 = String.valueOf(i);
            data.setTitle(data1);
            recyclerDataArrayList.add(data);
            counting = counting + Integer.toString(i) + "\n";
        }
        adapter.notifyDataSetChanged();
    }

    private void initTts(){
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });
    }

    public void speak(String text){
        t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    private void createCounting(){

    }
}