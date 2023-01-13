package com.example.mvc_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvc_demo.Controller.MainController;
import com.example.mvc_demo.databinding.ActivityMainBinding;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public TextView txtResult;
    public ProgressBar progressBar;
    public Button btnGetAnswer;

    MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        txtResult = findViewById(R.id.text_result);
        progressBar = findViewById(R.id.progressBar);
        btnGetAnswer = findViewById(R.id.btn_get_answer);

        mainController = new MainController(this);

        binding.btnGetAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainController.suggestDrink();
            }
        });
    }
}
