package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.project.kidzo.databinding.ActivityMainBinding;
import com.project.kidzo.databinding.ActivityRhymesBinding;

public class RhymesActivity extends AppCompatActivity {

    ActivityRhymesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhymes);
        binding = ActivityRhymesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

    }
    private void init(){
        binding.engRhymes.setOnClickListener(view -> {
            startActivity(new Intent(this,EnglishRhymeActivity.class));
        });
        binding.banglaRhymes.setOnClickListener(view -> {
            startActivity(new Intent(this,BanglaRhymeActivity.class));
        });
    }
}