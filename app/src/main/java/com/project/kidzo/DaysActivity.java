package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.project.kidzo.databinding.ActivityDaysBinding;
import com.project.kidzo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;

public class DaysActivity extends AppCompatActivity {

    ActivityDaysBinding binding;
    TextToSpeech t1;
    String days[] = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

        binding = ActivityDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.idCourseRV);
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        // added data from arraylist to adapter class.
        adapter=new RecyclerViewAdapter(recyclerDataArrayList,this,3);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
       // GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addData();
        initTts();

    }
    private void addData(){
        for (int i=0; i<days.length; i++){
            RecyclerData data = new RecyclerData();
            data.setTitle(days[i]);
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
                    //t1.setLanguage(new Locale("bn_IN"));
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