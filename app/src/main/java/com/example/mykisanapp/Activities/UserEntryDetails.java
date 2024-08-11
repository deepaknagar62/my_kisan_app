package com.example.mykisanapp.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mykisanapp.R;
import com.squareup.picasso.Picasso;

public class UserEntryDetails extends AppCompatActivity {
   TextView  textabout , textprice, textphone, textvillage,textdate;
   ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_entry_details);

        textabout = findViewById(R.id.textAboutuse);
        textprice = findViewById(R.id.textpriceuse);
        textvillage = findViewById(R.id.textvillageuse);
        textphone = findViewById(R.id.textphoneuse);
        textdate  = findViewById(R.id.textdateuse);
        img = findViewById(R.id.imguse);


        String about = getIntent().getStringExtra("about_sell");
        String price = getIntent().getStringExtra("price");
        String village = getIntent().getStringExtra("village");
        String phone = getIntent().getStringExtra("phone");
        String date = getIntent().getStringExtra("date");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        textabout.setText(about);
        textprice.setText(price);
        textvillage.setText(village);
        textphone.setText(phone);
        textdate.setText(date);
        Picasso.get().load(imageUrl).into(img);


    }
}