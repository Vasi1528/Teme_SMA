package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.StringBuffer;

public class H12Activity extends AppCompatActivity {
    private TextView lnktxt;
    private String   ExtrString,Str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
    }
    private void initializeViews() {
        lnktxt=findViewById(R.id.lnktxt);
        Intent intnt = getIntent();
        ExtrString = intnt.getStringExtra(Values.lnkvalue);
        Str = new StringBuilder(ExtrString).reverse().toString();
        lnktxt.setText(lnktxt.getText() + Str);
    }
}