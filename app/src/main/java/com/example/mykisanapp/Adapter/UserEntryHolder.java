package com.example.mykisanapp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.R;

public class UserEntryHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textViewAbout;
    public TextView textViewPrice;
    public TextView textViewDate;
    public TextView textViewvillage;
    public CardView cv;
    public UserEntryHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageViewUE);
        textViewAbout = itemView.findViewById(R.id.textViewAbout);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        textViewDate = itemView.findViewById(R.id.textViewDate);
        textViewvillage = itemView.findViewById(R.id.TextViewvillage);
        cv = itemView.findViewById(R.id.cardViewForward);
    }


}
