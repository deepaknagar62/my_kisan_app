package com.example.mykisanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.mykisanapp.Activities.ForgetPassword;
import com.example.mykisanapp.Activities.MainActivity;
import com.example.mykisanapp.Model.UserApi;
import com.example.mykisanapp.Retrofit.RetrofitService;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText tphone, tpassword;
    Button btn ;
    TextView btn2 ,forgetpass;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_login);

        tphone = findViewById(R.id.editTextPhone1);
        tpassword = findViewById(R.id.editTextPassword1);
        btn = findViewById(R.id.buttonLogin);
        btn2 = findViewById(R.id.gotoregister);
        forgetpass = findViewById(R.id.textforgetpass);


        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this , Register.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


        sharedPrefManager=new SharedPrefManager(getApplicationContext());

    }

    private void loginUser() {



        String phone = tphone.getText().toString().trim();
        String password = tpassword.getText().toString().trim();

        if (phone.isEmpty() || password.isEmpty() ) {
            Toast.makeText(this, "Please enter phone and password ", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestBody phonePart = RequestBody.create(MediaType.parse("text/plain"), phone);
        RequestBody passwordPart = RequestBody.create(MediaType.parse("text/plain"), password);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
        Call<LoginResponse> call = userApi.loginUser(phonePart,passwordPart);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

               LoginResponse loginResponse=response.body();
                if(response.isSuccessful()){

                      if(loginResponse.getMessage().equals("Login successful")){
                          Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                          Intent i = new Intent(Login.this, MainActivity.class);
                          i.setFlags(i.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
                          startActivity(i);
                          sharedPrefManager.saveUser(loginResponse.getData());
                      }


                }
                else{
                    Toast.makeText(Login.this, "Invalid Id or Password", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    protected void onStart(){
        super.onStart();

        if(sharedPrefManager.isLoggedIn()){
            Intent i = new Intent(Login.this, MainActivity.class);
            i.setFlags(i.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
}