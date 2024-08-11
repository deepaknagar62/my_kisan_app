package com.example.mykisanapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Model.Posts;
import com.example.mykisanapp.R;

import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postHolder> {
    List<Posts> postsList;
    Context context;

    public postAdapter(Context context ,List<Posts> posts){
        this.context = context;
        this.postsList = posts;
    }

    @NonNull
    @Override
    public postHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.list_user_item,parent,false);
        return new postHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postHolder holder, int position) {
      Posts post = postsList.get(position);
      holder.userid.setText(post.getUserId());
      holder.id.setText(post.getId());
      holder.title.setText(post.getTitle());
//      holder.body.setText(post.getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
