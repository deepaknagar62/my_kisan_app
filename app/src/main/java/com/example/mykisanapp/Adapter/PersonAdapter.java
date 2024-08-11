package com.example.mykisanapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Model.Person;
import com.example.mykisanapp.PersonDetailsActivity;
import com.example.mykisanapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> persons;
    private Context context;
    public PersonAdapter( Context context,List<Person> persons) {
        this.persons = persons;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);

        holder.textViewName.setText(person.getName());
        holder.textViewVillage.setText(person.getVillage());
        Picasso.get().load(person.getFileUrl()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPersonDetailsActivity(person);
            }
        });
    }

    private void openPersonDetailsActivity(Person person) {
        Intent intent = new Intent(context, PersonDetailsActivity.class);
        intent.putExtra("name", person.getName());
        intent.putExtra("village", person.getVillage());
        intent.putExtra("imageUrl", person.getFileUrl());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewVillage;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewVillage = itemView.findViewById(R.id.textViewVillage);
        }
    }
}