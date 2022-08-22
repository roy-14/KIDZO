package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.project.kidzo.databinding.ActivityAlphabetBinding;
import com.project.kidzo.databinding.ActivityMainBinding;

public class AlphabetActivity extends AppCompatActivity {

    ActivityAlphabetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        binding = ActivityAlphabetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }
    private void init(){
        binding.layoutEng.setOnClickListener(view -> {
            startActivity(new Intent(this,EnglishAlphabetActivity.class));
        });
        binding.layoutMaths.setOnClickListener(V->{
            startActivity(new Intent(this,MathsAlphabetActivity.class));
        });
    }
}