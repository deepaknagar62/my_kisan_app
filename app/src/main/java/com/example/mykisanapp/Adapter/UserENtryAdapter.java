package com.example.mykisanapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Activities.UserEntryDetails;
import com.example.mykisanapp.Model.UserEntryDTO;
import com.example.mykisanapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserENtryAdapter extends RecyclerView.Adapter<UserEntryHolder> {
    private List<UserEntryDTO> userEntryDTOList;
    Context context;

    public UserENtryAdapter(Context context ,List<UserEntryDTO> userEntryDTOList ){
        this.userEntryDTOList = userEntryDTOList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserEntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_userentry, parent, false);

        return new UserEntryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserEntryHolder holder, int position) {

        UserEntryDTO user = userEntryDTOList.get(position);

        holder.textViewAbout.setText(user.getAbout_sell());
        holder.textViewPrice.setText(user.getPrice());
        holder.textViewDate.setText(user.getDate());
        holder.textViewvillage.setText(user.getVillage());
        Picasso.get().load(user.getFileUrl()).into(holder.imageView);


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuserEntryDeatils(user);
            }
        });


    }

    private void openuserEntryDeatils(UserEntryDTO user) {
        Intent i = new Intent(context, UserEntryDetails.class);
        i.putExtra("about_sell", user.getAbout_sell());
        i.putExtra("price", user.getPrice());
        i.putExtra("village", user.getVillage());
        i.putExtra("phone", user.getPhone());
        i.putExtra("date", user.getDate());
        i.putExtra("imageUrl", user.getFileUrl());
        context.startActivity(i);

    }

    @Override
    public int getItemCount() {
        return userEntryDTOList.size();
    }
}
