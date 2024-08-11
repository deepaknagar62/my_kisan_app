package com.example.mykisanapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykisanapp.Adapter.UserENtryAdapter;
import com.example.mykisanapp.Model.UserEntryApi;
import com.example.mykisanapp.Model.UserEntryDTO;
import com.example.mykisanapp.R;
import com.example.mykisanapp.Retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public UserENtryAdapter userENtryAdapter;
    private static final String TAG = "AnimalActivity";
    private FloatingActionButton fabutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        recyclerView =  (RecyclerView) findViewById(R.id.recycleView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        intilizeComponent();


        fabutton = findViewById(R.id.fab);
        fabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAnimals();
            }
        });



    }

    private void openAddAnimals() {
        Intent i = new Intent(AnimalActivity.this ,AddAnimalsActivity.class);
        startActivity(i);
    }

    private void intilizeComponent() {
        RetrofitService retrofitService = new RetrofitService();
        UserEntryApi userEntryApi = retrofitService.getRetrofit().create(UserEntryApi.class);
        Call<List<UserEntryDTO>> call = userEntryApi.getAllAnimals();
        call.enqueue(new Callback<List<UserEntryDTO>>() {
            @Override
            public void onResponse(Call<List<UserEntryDTO>> call, Response<List<UserEntryDTO>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AnimalActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    List<UserEntryDTO> list = response.body();

                    if(list !=null){
                        userENtryAdapter = new UserENtryAdapter(AnimalActivity.this,list);
                        recyclerView.setAdapter(userENtryAdapter);
                    }

                }
                else{

                        Log.e("FetchPersons", "Response error: " + response.code());
                        Toast.makeText(AnimalActivity.this, "Failed to fetch UserEntry", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<UserEntryDTO>> call, Throwable t) {
                Log.e("FetchUserEntry", "Request failed: " + t.getMessage());
                Toast.makeText(AnimalActivity.this, "Failed ...", Toast.LENGTH_SHORT).show();
            }
        });

    }


//    private void populateView(List<UserEntryDTO> emplist) {
//       UserAdapter userAdapter = new UserAdapter(AnimalActivity.this , emplist);
//       recyclerView.setAdapter(userAdapter);
//        Toast.makeText(AnimalActivity.this, "Successful", Toast.LENGTH_SHORT).show();
//    }
}