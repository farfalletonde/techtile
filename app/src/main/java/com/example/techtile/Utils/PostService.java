package com.example.techtile.Utils;

import com.example.techtile.Model.LoginModel;
import com.example.techtile.Model.RegisterModel;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface PostService {
    @Headers({
            "Content-type: application/json"
    })
    @POST("signup?id=b74a8e1c-2749-442f-b6ef-8e0abf3737f5")
    Call<String> register(@Query("id") String id, @Body RegisterModel model);
    @Headers({
            "Content-type: application/json"
    })
    @PUT("login?id=b74a8e1c-2749-442f-b6ef-8e0abf3737f5")
    Call<String> login(@Body LoginModel model);
}
