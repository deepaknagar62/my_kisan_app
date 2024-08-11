package com.example.mykisanapp.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.R;

public class EmployHolder extends RecyclerView.ViewHolder {

    TextView name , city, branch;
    public EmployHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.itemEmpName);
        city = itemView.findViewById(R.id.itemEmpBranch);
        branch = itemView.findViewById(R.id.itemEmpCity);

    }


}
