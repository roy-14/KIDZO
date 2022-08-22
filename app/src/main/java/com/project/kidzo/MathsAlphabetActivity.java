package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.project.kidzo.databinding.ActivityMathsAlphabetBinding;


public class MathsAlphabetActivity extends AppCompatActivity {
    ActivityMathsAlphabetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_alphabet);

        binding = ActivityMathsAlphabetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }
    private void init(){
        binding.mathsEng.setOnClickListener(view -> {
            startActivity(new Intent(this,MathsActivity.class));
        });
        binding.mathsBangla.setOnClickListener(view -> {
            startActivity(new Intent(this,MathsBanglaActivity.class));
        });
    }
}