package com.example.mykisanapp.Model;

import com.example.mykisanapp.LoginResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserApi {
    @GET("/user/getall")
    Call<List<User>> getAllUsers();

    @POST("/user/register")
    Call<User> saveUsers(@Body User user);

    @Multipart
    @POST("/user/login")
    Call<LoginResponse> loginUser(
            @Part("phone") RequestBody phone,
            @Part("password") RequestBody password);


}
