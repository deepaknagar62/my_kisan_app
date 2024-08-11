package com.example.mykisanapp.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.R;

public class postHolder  extends RecyclerView.ViewHolder {
    TextView userid, id, title,body;

    public postHolder(@NonNull View itemView) {
        super(itemView);

        userid = itemView.findViewById(R.id.itemUserId);
        id = itemView.findViewById(R.id.itemId);
        title = itemView.findViewById(R.id.itemCity);
//        body = itemView.findViewById(R.id.itemBody);
    }
}
