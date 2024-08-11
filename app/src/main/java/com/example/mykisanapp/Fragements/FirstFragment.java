package com.example.mykisanapp.Fragements;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.mykisanapp.Activities.AnimalActivity;
import com.example.mykisanapp.Activities.Crops;
import com.example.mykisanapp.Activities.MachineActivity;
import com.example.mykisanapp.Activities.MainActivity;
import com.example.mykisanapp.Activities.RentActivity;
import com.example.mykisanapp.R;


public class FirstFragment extends Fragment {
   MainActivity mainActivity;
    ImageView card1 ,card2,card3,card4;;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View rootview =  inflater.inflate(R.layout.fragment_first, container, false);
         mainActivity = (MainActivity) getActivity();


         card1 =  (ImageView) rootview.findViewById(R.id.cardView1);
         card1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getActivity() , Crops.class);
                 startActivity(i);
             }
         });

        card2 =  (ImageView) rootview.findViewById(R.id.cardView2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() , AnimalActivity.class);
                startActivity(i);
            }
        });

        card3 =  (ImageView) rootview.findViewById(R.id.cardView3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() , MachineActivity.class);
                startActivity(i);
            }
        });


        card4 =  (ImageView) rootview.findViewById(R.id.cardView4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() , RentActivity.class);
                startActivity(i);
            }
        });

        return rootview;
    }


}