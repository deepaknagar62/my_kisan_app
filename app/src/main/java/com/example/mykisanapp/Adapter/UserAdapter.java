package com.example.mykisanapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Model.User;
import com.example.mykisanapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {
   private List<User> userList;
    Context context;

    public UserAdapter(Context context ,List<User> userList) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user_item , parent , false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
      User user = userList.get(position);
////      holder.id.setText(user.getId());
//      holder.name.setText(user.getName());
//      holder.city.setText(user.getCity());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
