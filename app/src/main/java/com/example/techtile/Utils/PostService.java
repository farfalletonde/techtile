package com.example.techtile.Utils;

import com.example.techtile.Model.LoginModel;
import com.example.techtile.Model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostService {
    @Headers({
            "Content-type: application/json"
    })
    @POST("signup")
    Call<RegisterModel> register(@Query("id") String id, @Body RegisterModel model);

    @Headers({
            "Content-type: application/json"
    })
    @PUT("login")
    Call<LoginModel> login(@Path("id") String id, @Body LoginModel model);
}
