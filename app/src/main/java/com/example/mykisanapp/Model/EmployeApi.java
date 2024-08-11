package com.example.mykisanapp.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeApi {

    @GET("/emp/getallEmp")
    Call<List<Employee>> getAllEmploy();

    @POST("/emp/saveEmp")
    Call<Employee> saveEmploys(@Body Employee employee);
}
