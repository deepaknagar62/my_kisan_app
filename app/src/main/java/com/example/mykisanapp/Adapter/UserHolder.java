package com.example.mykisanapp.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserHolder extends RecyclerView.ViewHolder {
    TextView id, name , city;

    public UserHolder(@NonNull View itemView) {
        super(itemView);
//        id = itemView.findViewById(R.id.itemUserId);
//        name = itemView.findViewById(R.id.itemId);
//        city = itemView.findViewById(R.id.itemCity);
    }
}
