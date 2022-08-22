package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.project.kidzo.databinding.ActivityDaysBinding;
import com.project.kidzo.databinding.ActivityMonthsBinding;

import java.util.ArrayList;
import java.util.Locale;

public class MonthsActivity extends AppCompatActivity {

    ActivityMonthsBinding binding;
    TextToSpeech t1;
    String months[] = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER",
                    "DECEMBER"};
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);

        binding = ActivityMonthsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.idCourseRV);
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        // added data from arraylist to adapter class.
        adapter = new RecyclerViewAdapter(recyclerDataArrayList,this,4);

        // setting grid layout manager to implement grid view.

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addData();
        initTts();

    }
    private void addData(){
        for (int i=0; i<months.length; i++){
            RecyclerData data = new RecyclerData();
            data.setTitle(months[i]);
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