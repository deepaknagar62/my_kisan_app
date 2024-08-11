package com.example.mykisanapp.Fragements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mykisanapp.R;
import com.example.mykisanapp.SharedPrefManager;


public class Profile extends Fragment {
      private  TextView tid,tname,tvillage,tphone;
      private SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);


         tname=rootview.findViewById(R.id.txtname);
         tvillage=rootview.findViewById(R.id.txtvillage);
         tphone=rootview.findViewById(R.id.txtphone);

         sharedPrefManager=new SharedPrefManager(getActivity());

        String nameu = "Name : " + sharedPrefManager.getUser().getName();
        tname.setText(nameu);
        String vill = "Village : " + sharedPrefManager.getUser().getVillage();
        tvillage.setText(vill);
        String phn = "Phone : " + sharedPrefManager.getUser().getPhone();
        tphone.setText(phn);




        return rootview;
    }


}