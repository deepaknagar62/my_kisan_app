package com.example.mykisanapp.Model;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserEntryApi {

    @Multipart
    @POST("/userEntry/save")
    Call<UserEntry> saveUserData(@Part  ("phone") RequestBody phone,
                                 @Part("village")  RequestBody village,
                                 @Part MultipartBody.Part  file,
                                 @Part("type_sell")  RequestBody type_sell,
                                 @Part("price")  RequestBody price,
                                 @Part("about_sell")  RequestBody about_sell,
                                 @Part("date")  RequestBody date,
                                 @Part("userId") RequestBody userId);


    @GET("/userEntry/getallcrops")
    Call<List<UserEntryDTO>> getAllRecords();

    @GET("/userEntry/getallanimals")
    Call<List<UserEntryDTO>> getAllAnimals();

    @GET("/userEntry/getallmachines")
    Call<List<UserEntryDTO>> getAllMachines();
}
