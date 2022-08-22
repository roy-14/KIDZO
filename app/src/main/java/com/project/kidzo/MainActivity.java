package com.project.kidzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.kidzo.TicTac.TicTacActivity;
import com.project.kidzo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MusicManager mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        init();
    }
    private void init(){
        // calling alphabet activity
        binding.layAlpha.setOnClickListener(view -> {
            moveToAlphaActivity();
        });
        // calling rhymes activity
        binding.layRhymes.setOnClickListener(view -> {
            moveToRhymeActivity();
        });
        // calling puzzles activity
        binding.layPuzzles.setOnClickListener(view -> {
            moveToPuzzleActivity();
        });
        // calling quiz activity
        binding.layMonths.setOnClickListener(view -> {
            moveToMonthsActivity();
        });
        binding.layDays.setOnClickListener(view -> {
            moveToDaysActivity();
        });

        //background music
       mm = new MusicManager(this, R.raw.bg_music);
    }
    private void moveToAlphaActivity(){
       startActivity( new Intent(this, AlphabetActivity.class));
    }

    private void moveToRhymeActivity(){
        startActivity(new Intent(this, RhymesActivity.class));
    }

    private void moveToPuzzleActivity(){
        startActivity(new Intent(this,PuzzleActivity.class));
    }

    private void moveToMonthsActivity(){
        startActivity(new Intent(this, MonthsActivity.class));
    }

    private void moveToDaysActivity(){
        startActivity(new Intent(this,DaysActivity.class));
    }

    public void onDestroy() {
        super.onDestroy();
        mm.stop();
    }

    public void onPause(){
        super.onPause();
        mm.stop();
    }

    public void onResume(){
        super.onResume();
        mm.play();
    }

    public void gotoTicTac(View view) {
        startActivity(new Intent(this, TicTacActivity.class));
    }

    public void gotoMathQuiz(View view) {
        startActivity(new Intent(this,MathQuizActivity.class));
    }
}