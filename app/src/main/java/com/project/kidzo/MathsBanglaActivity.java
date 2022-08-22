package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;

public class MathsBanglaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    RecyclerViewAdapter adapter;
    String alphabets[] = {"০", "১" , "২" ,  "৩" ,  "৪" ,  "৫" ,  "৬" ,  "৭" ,  "৮" ,  "৯" ,  "১০" ,  "১১" ,  "১২" ,  "১৩" ,  "১৪" ,  "১৫" ,  "১৬" ,  "১৭" ,  "১৮" ,  "১৯" ,  "২০" ,  "২১" ,  "২২" ,  "২৩" ,  "২৪" ,  "২৫" ,  "২৬" ,  "২৭" ,  "২৮" ,  "২৯" ,  "৩০" ,  "৩১" ,  "৩২" ,  "৩৩" ,  "৩৪" ,  "৩৫" ,  "৩৬" ,  "৩৭" ,  "৩৮" ,  "৩৯" ,  "৪০" ,  "৪১" ,  "৪২" ,  "৪৩" ,  "৪৪" ,  "৪৫" ,  "৪৬" ,  "৪৭" ,  "৪৮" ,  "৪৯" ,  "৫০" ,  "৫১" ,  "৫২" ,  "৫৩" ,  "৫৪" ,  "৫৫" ,  "৫৬" ,  "৫৭" ,  "৫৮" ,  "৫৯" ,  "৬০" ,  "৬১" ,  "৬২" ,  "৬৩" ,  "৬৪" ,  "৬৫" ,  "৬৬" ,  "৬৭" ,  "৬৮" ,  "৬৯" ,  "৭০" ,  "৭১" ,  "৭২" ,  "৭৩" ,  "৭৪" ,  "৭৫" ,  "৭৬" ,  "৭৭" ,  "৭৮" ,  "৭৯" ,  "৮০" ,  "৮১" ,  "৮২" ,  "৮৩" ,  "৮৪" ,  "৮৫" ,  "৮৬" ,  "৮৭" ,  "৮৮" ,  "৮৯" ,  "৯০" ,  "৯১" ,  "৯২" ,  "৯৩" ,  "৯৪" ,  "৯৫" ,  "৯৬" ,  "৯৭" ,  "৯৮" ,  "৯৯" ,  "১০০"};
    TextToSpeech t1;
    String counting = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_bangla);

        recyclerView = findViewById(R.id.idCourseRV);
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        // added data from arraylist to adapter class.
        adapter=new RecyclerViewAdapter(recyclerDataArrayList,this,2);

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
           // String data1 = String.valueOf(i);
            data.setTitle(alphabets[i]);
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
                    t1.setLanguage(new Locale("bn_IN"));
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