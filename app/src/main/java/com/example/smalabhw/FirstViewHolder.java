package com.example.smalabhw;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirstViewHolder extends RecyclerView.ViewHolder{
    private TextView nameTV;
    private TextView firstnameTV;
    private TextView ageTV;
    public FirstViewHolder(@NonNull View itemView) {
        super(itemView);
        initializeViews();
    }

    private void initializeViews() {
        nameTV=itemView.findViewById(R.id.row_first_name);
        firstnameTV=itemView.findViewById(R.id.row_first_firstname);
        ageTV=itemView.findViewById(R.id.row_first_age);
    }
    public void setValues(String name,String firstname,int age){
        nameTV.setText("Nume: " + name);
        firstnameTV.setText("Prenume: " + firstname);
        ageTV.setText("Varsta: " + age);
    }
}
