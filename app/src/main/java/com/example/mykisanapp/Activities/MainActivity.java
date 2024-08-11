package com.example.mykisanapp.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykisanapp.Fragements.AddProduct;
import com.example.mykisanapp.Fragements.FirstFragment;
import com.example.mykisanapp.Fragements.Profile;
import com.example.mykisanapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity  implements BottomNavigationView
        .OnNavigationItemSelectedListener
 {

     BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);



    }

     FirstFragment firstFragment = new FirstFragment();
     AddProduct secondFragment = new AddProduct();
     Profile fourthFragment = new Profile();

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId()) {
             case R.id.home:
                 getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.flFragment, firstFragment)
                         .commit();
                 return true;

             case R.id.add_product:
                 getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.flFragment, secondFragment)
                         .commit();
                 return true;


             case R.id.profile:
                 getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.flFragment, fourthFragment)
                         .commit();
                 return true;
         }
         return false;
     }







}