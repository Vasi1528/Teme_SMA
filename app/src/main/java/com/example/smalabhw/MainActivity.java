package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button hw1btn,hw2btn,hw3btn,hw4btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        hw1btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,Hw1Activity.class);
                startActivity(intent);
            }
        });
        hw2btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,Hw2Activity.class);
                startActivity(intent);
            }
        });
        hw3btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,Hw3Activity.class);
                startActivity(intent);
            }
        });
        hw4btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,Hw4Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        hw1btn = findViewById(R.id.hw1btn);
        hw2btn = findViewById(R.id.hw2btn);
        hw3btn = findViewById(R.id.hw3btn);
        hw4btn = findViewById(R.id.hw4btn);

    }


}