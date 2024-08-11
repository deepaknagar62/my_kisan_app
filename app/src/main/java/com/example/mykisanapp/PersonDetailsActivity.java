package com.example.mykisanapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PersonDetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        imageView = findViewById(R.id.imageView);
        textViewName = findViewById(R.id.textViewName);
        textViewVillage = findViewById(R.id.textViewVillage);

        // Get data from the Intent
        String name = getIntent().getStringExtra("name");
        String village = getIntent().getStringExtra("village");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        // Set data to views
        textViewName.setText(name);
        textViewVillage.setText(village);
        Picasso.get().load(imageUrl).into(imageView);
    }
}