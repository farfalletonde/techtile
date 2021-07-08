package com.example.techtile.Utils;

import android.util.Log;
import android.widget.Toast;

import com.example.techtile.Model.LoginModel;
import com.example.techtile.Model.RegisterModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    //https://welive-app.com:443/api/v1/entrance/signup?id=b74a8e1c-2749-442f-b6ef-8e0abf3737f5
    private static final String TAG = "TAG";

    private final String BaseUrl = "https://welive-app.com:443/api/v1/entrance/";
    private ApiResultListener listener;
    private Retrofit retrofit;
    private PostService postService;

    public Api(ApiResultListener listener) {
        this.listener = listener;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public Api() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public void login(LoginModel model){


        postService = retrofit.create(PostService.class);

        Call<String> call = postService.login(model);
        // JsonObject x = new JsonObject();
        listener.onPreExecute();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response.isSuccessful()) {
                    listener.onPostExecute(response.body().toString(), true);
                } else {
                    listener.onPostExecute(response.message(), false);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

               // Toast.makeText(, "Failure", Toast.LENGTH_SHORT).show();
                listener.onPostExecute("fail", false);
            }
        });



    }
    public void register(RegisterModel model){
        postService = retrofit.create(PostService.class);
        Call<String> call = postService.register("b74a8e1c-2749-442f-b6ef-8e0abf3737f5",model);
        listener.onPreExecute();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Log.d("asdsadsaasdsa", "onResponse: " + response.isSuccessful());
                Log.d("NEW API", response.code() + "");
                Log.d("NEW API", response.message() + "");
                //     Log.d(TAG, "onResponse: " + response.body().toString());
                if (response.isSuccessful()) {
                    listener.onPostExecute(response.body().toString(), true);
                } else {
                    listener.onPostExecute(response.message(), false);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("onFailure", call.toString());
                Log.d(TAG, "onFailure: "+t );
                listener.onPostExecute("fail", false);
            }
        });
    }


    public interface ApiResultListener {
        void onPreExecute();
        void onPostExecute(String data, boolean isReqSuccess);
    }
}
