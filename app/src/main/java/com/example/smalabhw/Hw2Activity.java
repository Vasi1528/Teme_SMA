package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Hw2Activity extends AppCompatActivity {
private Button dialButton,okButton,cancelButton;
private LinearLayout dialog;
private EditText dialText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        dialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.setVisibility(View.VISIBLE);
            }
        });
        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if( dialText.getText().toString().matches("")) {
                    Toast.makeText(Hw2Activity.this,"Textul este gol",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Hw2Activity.this, H22Activity.class);
                    intent.putExtra(Values.lnkvalue, dialText.getText().toString());
                    startActivity(intent);
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Hw2Activity.this,"Activitate oprita",Toast.LENGTH_LONG).show();
                dialog.setVisibility(View.GONE);
            }
        });
}

    private void initializeViews() {
            dialButton = findViewById(R.id.dialbutton);
            okButton = findViewById(R.id.okbutton);
            cancelButton = findViewById(R.id.cancelbutton);
            dialog = findViewById(R.id.secondlayout);
            dialText = findViewById(R.id.dialtext);

    }
}