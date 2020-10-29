package com.example.smalabhw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstViewHolder>{
    private List<FirstModel> firstModelList;
    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_first_example,parent,false);
        return new FirstViewHolder(view);
    }
    public FirstAdapter(List<FirstModel> firstModelList){
        this.firstModelList = firstModelList;
    }
    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder viewHolder, int position) {
        FirstModel firstModel=firstModelList.get(position);
        viewHolder.setValues(firstModel.getName(),firstModel.getFirstName(),firstModel.getAge());
    }

    @Override
    public int getItemCount() {
        return firstModelList.size();
    }
}
