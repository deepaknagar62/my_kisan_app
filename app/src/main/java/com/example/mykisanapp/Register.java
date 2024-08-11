package com.example.mykisanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mykisanapp.Model.User;
import com.example.mykisanapp.Model.UserApi;
import com.example.mykisanapp.Retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText textname, textphone, textvillage, textpassword;
    Button btnregister;
    TextView  txtlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textname = findViewById(R.id.editTextName);
        textphone = findViewById(R.id.editTextPhone);
        textvillage = findViewById(R.id.editTextVillage);
        textpassword = findViewById(R.id.editTextPassword);
        txtlogin = findViewById(R.id.haveaccount);

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this , Login.class);
                startActivity(intent);
            }
        });
        btnregister = findViewById(R.id.buttonRegister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = textname.getText().toString().trim();
        String phone = textphone.getText().toString().trim();
        String village = textvillage.getText().toString().trim();
        String password = textpassword.getText().toString().trim();
        if (name.isEmpty() || village.isEmpty() || phone.isEmpty() || password.isEmpty() ) {
            Toast.makeText(this, "Please fill all the fields ", Toast.LENGTH_SHORT).show();
            return;
        }

        User u = new User();
        u.setName(name);
        u.setPhone(phone);
        u.setVillage(village);
        u.setPassword(password);


        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
        Call<User> call = userApi.saveUsers(u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Register.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_SHORT).show();
            }
        });
    }
}