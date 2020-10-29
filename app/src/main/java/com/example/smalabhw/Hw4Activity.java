package com.example.smalabhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Hw4Activity extends AppCompatActivity {
    private Button showButton,showAnswerButton,fileButton,fileWrButton;
    private EditText hiddenText,prefText,pref2Text,searchText,hiddenFileText;
    private FileModel fileModel = new FileModel("spun ceva");
    private String stringFromFile = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( prefText.getText().toString().matches("")  ||  pref2Text.getText().toString().matches("")) {
                    Toast.makeText(Hw4Activity.this,"Date insuficiente",Toast.LENGTH_LONG).show();
                }
                else {
                    addPref(prefText.getText().toString(),pref2Text.getText().toString());
                    prefText.setText("");
                    pref2Text.setText("");
                }
            }
        });
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( searchText.getText().toString().matches("")) {
                    Toast.makeText(Hw4Activity.this,"Textul este gol",Toast.LENGTH_LONG).show();
                }
                else {
                    getPref(searchText.getText().toString());
                }
            }
        });
        fileWrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileWr();
            }
        });
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               fileRd();
            }
        });
    }
    private void initializeViews() {
        fileButton = findViewById(R.id.filebtn);
        fileWrButton = findViewById(R.id.filewrbtn);
        showButton = findViewById(R.id.showbtn);
        showAnswerButton = findViewById(R.id.showanswerbtn);
        prefText = findViewById(R.id.preftxt);
        hiddenText = findViewById(R.id.hiddentxt);
        hiddenFileText = findViewById(R.id.hiddenfiletxt);
        pref2Text = findViewById(R.id.pref2txt);
        searchText = findViewById(R.id.searchtxt);
    }
    private void addPref(String text1,String text2) {
        SharedPreferences.Editor editor = getSharedPreferences("FisPref", MODE_PRIVATE).edit();
        editor.putString(text1, text2);
        editor.apply();



    }
    private void getPref(String text1){
        SharedPreferences prefs = getSharedPreferences("FisPref", MODE_PRIVATE);
        String showedText = prefs.getString(text1, "Nu s-a gasit valoare pentru numele dat");

        hiddenText.setVisibility(View.VISIBLE);
        hiddenText.setText("Raspuns: " + showedText);


    }
    private void fileWr(){
 try {
     Gson gson = new Gson();
     String data = gson.toJson(fileModel);
     OutputStreamWriter outputStreamWriter =
             new OutputStreamWriter(this.openFileOutput("firstFis.txt", Context.MODE_PRIVATE));
        outputStreamWriter.write(data);
        outputStreamWriter.close();
       // startActivity(new Intent(Hw4Activity.this,MainActivity.class));
     hiddenFileText.setVisibility(View.VISIBLE);
     hiddenFileText.setText(stringFromFile);
        Toast.makeText(this,"Salvat cu succes",Toast.LENGTH_SHORT).show();
    } catch (IOException e){
     Toast.makeText(Hw4Activity.this,"Eroare la salvare",Toast.LENGTH_LONG).show();
     Log.e("declaration activity","Eroare la salvare" + e.toString());
 }

    }
    private void fileRd(){

        try {
            InputStream inputStream = this.openFileInput("firstFis.txt");
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            StringBuilder stringBuilder =new StringBuilder();
            while ( (receiveString =bufferedReader.readLine())!=null ){
                stringBuilder.append(receiveString);
            }
            inputStream.close();
            stringFromFile = stringBuilder.toString();
        }

        }
        catch(FileNotFoundException e){
            Toast.makeText(Hw4Activity.this,"File not found",Toast.LENGTH_LONG).show();
            Log.e("declaration activity","File not found" + e.toString());
        }
        catch (IOException e){
            Toast.makeText(Hw4Activity.this,"Cannot read file",Toast.LENGTH_LONG).show();
            Log.e( "hw4 activity","Can not read file" + e.toString());
        }
        Gson gson = new Gson();
        FileModel savedDeclarationModel = gson.fromJson(stringFromFile , FileModel.class);

    }

}