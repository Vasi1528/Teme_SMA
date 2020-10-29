package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Hw3Activity extends AppCompatActivity {
    private RecyclerView firstRv;
    private FirstAdapter firstAdapter;
    private List<FirstModel> firstModelList;
    private EditText agetxt,nametxt,fnametxt,rmvIdx;
    private Button addButton,cancelButton,rmvButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw3);
        initalizeViews();
        setOnClickListeners();
        initalizeList();
        setRecyclerView();
    }

    private void setOnClickListeners() {
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(!agetxt.getText().toString().isEmpty()) {
                    String value = agetxt.getText().toString();
                    int intValue = Integer.parseInt(value);

                    if (nametxt.getText().toString().matches("") || fnametxt.getText().toString().matches("") || agetxt.getText().toString().isEmpty()) {
                        Toast.makeText(Hw3Activity.this, "Date insuficiente", Toast.LENGTH_LONG).show();
                    } else {
                        firstModelList.add(new FirstModel(nametxt.getText().toString(), fnametxt.getText().toString(), intValue));
                        firstAdapter = new FirstAdapter(firstModelList);
                        firstRv.setLayoutManager(new LinearLayoutManager(Hw3Activity.this));
                        firstRv.setAdapter(firstAdapter);
                    }
                }
                else
                {
                    Toast.makeText(Hw3Activity.this, "Date insuficiente", Toast.LENGTH_LONG).show();
                }
                }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            nametxt.setText("");
            fnametxt.setText("");
            agetxt.setText("");
            }
        });
        rmvButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int val =  Integer.parseInt(rmvIdx.getText().toString());
                if(val <= firstModelList.size())
                firstModelList.remove(val - 1);
                else
                    Toast.makeText(Hw3Activity.this,"Index mai mare decat lungimea listei",Toast.LENGTH_LONG).show();
                firstAdapter = new FirstAdapter(firstModelList);
                firstRv.setLayoutManager(new LinearLayoutManager(Hw3Activity.this));
                firstRv.setAdapter(firstAdapter);
            }
        });

    }


    private void initalizeViews() {
        firstRv = findViewById(R.id.rv_test_list);
        agetxt = findViewById(R.id.agetxt);
        nametxt = findViewById(R.id.nametxt);
        fnametxt = findViewById(R.id.fnametxt);
        addButton = findViewById(R.id.addbutton);
        cancelButton = findViewById(R.id.cancelbutton);
        rmvButton = findViewById(R.id.rmvbutton);
        rmvIdx = findViewById(R.id.rmvIdx);
    }

    public void initalizeList(){
        firstModelList = new ArrayList<>();
        firstModelList.add(new FirstModel("Dan","BBB",6));
        firstModelList.add(new FirstModel("Alex","BB",12));
        firstModelList.add(new FirstModel("Dan","BBB",22));
        firstModelList.add(new FirstModel("Dan","BBB",32));
    }
    private void setRecyclerView() {
        firstAdapter = new FirstAdapter(firstModelList);
        firstRv.setLayoutManager(new LinearLayoutManager(this));
        firstRv.setAdapter(firstAdapter);
    }
    }
