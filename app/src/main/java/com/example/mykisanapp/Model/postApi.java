package com.example.mykisanapp.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface postApi {

    @GET("posts")
    Call<List<Posts>> getpost();
}
