package com.example.rxjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder>{

    private final List<Entry> entries =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //holder.txtName.setText(stringValues.get(position));

        Entry entry = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setTxtPrice(entry.getEntryPrice());
        holder.setTxtDate(entry.getEntryDate());

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addEntry(Entry entry) {

        entries.add(entry);
        notifyItemInserted(entries.size() - 1);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;
        @BindView(R.id.txtDate)
        TextView txtDate;

        private final NumberFormat ENTRY_PRICE_FORMAT = new DecimalFormat("$#0.00");

        public void setTxtName(String en) {
            this.txtName.setText(en);
        }

        public void setTxtPrice(BigDecimal ep) {
            this.txtPrice.setText(ENTRY_PRICE_FORMAT.format(ep.doubleValue()));
        }

        public void setTxtDate(Date ed) {
            this.txtDate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm", ed));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}
