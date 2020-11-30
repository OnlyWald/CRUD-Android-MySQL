package com.example.crud.API;

import com.example.crud.Model.responModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiRequestData {
    @GET("mahasiswa")
    Call<responModel> ardGetMahasiswa();
}
