package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hw1Activity extends AppCompatActivity {
    private Button lnk1btn,lnk2btn;
    private EditText lnktxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
        setOnClickListeners();
    }


    private void initializeViews() {
        lnk1btn = findViewById(R.id.lnk1btn);
        lnk2btn = findViewById(R.id.lnk2btn);
        lnktxt = findViewById(R.id.lnktxt);
    }
    private void setOnClickListeners() {
        lnk1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( lnktxt.getText().toString().matches("")) {
                    Toast.makeText(Hw1Activity.this,"Textul este gol",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Hw1Activity.this, H11Activity.class);
                    intent.putExtra(Values.lnkvalue, lnktxt.getText().toString());
                    startActivity(intent);
                }
            }
        });
        lnk2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnktxt.getText().toString().matches("")) {
                    Toast.makeText(Hw1Activity.this, "Textul este gol", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Hw1Activity.this, H12Activity.class);
                    intent.putExtra(Values.lnkvalue, lnktxt.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}