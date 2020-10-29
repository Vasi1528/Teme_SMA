package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class H22Activity extends AppCompatActivity {
private TextView textvw;
    private String ExtrString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h22);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
    }

    private void initializeViews() {
        textvw = findViewById(R.id.textvw);
        Intent int2 = getIntent();
        ExtrString = int2.getStringExtra(Values.lnkvalue);
        textvw.setText("Raspuns:" + ExtrString);
    }
}