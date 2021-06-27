package com.example.simpleaudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simpleaudioapp.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer audio;
    ActivityMainBinding binding;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playButton = binding.playButton;
        audio = MediaPlayer.create(this,R.raw.tujha_kitna_chaahne_lage);
        playButton.setOnClickListener(view -> {
          audio.start();
        });

        binding.pauseButton.setOnClickListener(view -> {
            audio.pause();
        });

        binding.stopButton.setOnClickListener(view -> {
            audio.stop();
            audio = MediaPlayer.create(this,R.raw.tujha_kitna_chaahne_lage);
        });

    }
}