package com.example.rxjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder>{

    private final List<String> stringValues =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtName.setText(stringValues.get(position));

    }

    @Override
    public int getItemCount() {
        return stringValues.size();
    }

    public void addStringToList(String value) {

        stringValues.add(value);
        notifyItemInserted(stringValues.size() - 1);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}
