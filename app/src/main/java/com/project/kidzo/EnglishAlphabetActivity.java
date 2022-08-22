package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;

public class EnglishAlphabetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    String alphabets[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    RecyclerViewAdapter adapter;
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_alphabet);
        recyclerView = findViewById(R.id.idCourseRV);
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        // added data from arraylist to adapter class.
        adapter=new RecyclerViewAdapter(recyclerDataArrayList,this,0);

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
        for (int i=0; i<alphabets.length; i++){
            RecyclerData data = new RecyclerData();
            data.setTitle(alphabets[i]);
            recyclerDataArrayList.add(data);
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
}