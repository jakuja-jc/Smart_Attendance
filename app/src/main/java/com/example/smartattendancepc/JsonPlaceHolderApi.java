package com.example.smartattendancepc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("employee")
    Call<List<Post>> getPost();

}
