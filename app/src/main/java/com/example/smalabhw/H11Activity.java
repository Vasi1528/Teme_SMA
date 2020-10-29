package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class H11Activity extends AppCompatActivity {
private TextView lnktxt;
 private String   ExtrString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
    }

    private void initializeViews() {
        lnktxt=findViewById(R.id.lnktxt);
        Intent intnt = getIntent();
        ExtrString = intnt.getStringExtra(Values.lnkvalue);
        lnktxt.setText(lnktxt.getText() + ExtrString);
    }
}