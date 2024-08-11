package com.example.mykisanapp.Model;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PersonApi {

    @GET("/person/getall")
    Call<List<Person>> getAllPersons();

    @Multipart
    @POST("/person/save")
    Call<Person> savePerson(@Part MultipartBody.Part file,
                            @Part("name") RequestBody name,
                            @Part("village") RequestBody village);
}
