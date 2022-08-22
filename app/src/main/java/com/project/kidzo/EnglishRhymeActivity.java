package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.project.kidzo.databinding.ActivityEnglishRhymeBinding;

import java.util.Locale;

public class EnglishRhymeActivity extends AppCompatActivity {
    ActivityEnglishRhymeBinding binding;
    TextToSpeech t1;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_rhyme);
        binding = ActivityEnglishRhymeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initTts();
    }

    private void initView(){
        binding.txtPoem.setText("");
        binding.txtPoem.setText(Poems.poems[0].trim());
        binding.imgSpeak.setOnClickListener(v->{
            t1.speak(binding.txtPoem.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
        });
        binding.btnNext.setOnClickListener(v->{
            if (position < Poems.poems.length-1){
                position++;
            }
            changePoem(position);
        });
        binding.btnPrevious.setOnClickListener(v->{
            if (position > 0){
                position--;
            }
            changePoem(position);
        });
    }

    private void initTts(){
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                    t1.setPitch(0.75f);
                }
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    private void changePoem(int position){
        binding.txtPoem.setText(Poems.poems[position].trim());
    }

}