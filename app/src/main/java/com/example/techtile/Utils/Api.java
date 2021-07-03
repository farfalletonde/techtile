package com.example.techtile.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
  /*  private static final String TAG = "TAG";

    private final String BaseUrl = "https://eu-api.backendless.com/";
    private ApiResultListener listener;
    private Retrofit retrofit;
    private PostService postService;

    public Api(ApiResultListener listener) {
        this.listener = listener;
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Api() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    // https://eu-api.backendless.com/{{APPLICATION_ID}}/{{API_KEY}}/users/login
    public void loginByPin(String p) {
        postService = retrofit.create(PostService.class);

        Call<Pin> call = postService.loginByPin(pin);
        listener.onPreExecute();
        call.enqueue(new Callback<Pin>() {
            @Override
            public void onResponse(Call<Pin> call, retrofit2.Response<Pin> response) {
                Log.d("NEW API", response.code() + "");
                Log.d("NEW API", response.message() + "");
                if (response.isSuccessful()) {
                    listener.onPostExecute(response.body().toString(), true);
                } else {
                    listener.onPostExecute(response.message(), false);
                }
            }
            @Override
            public void onFailure(Call<Pin> call, Throwable t) {
                Log.d("onFailure", call.toString());
                Log.d(TAG, "onFailure: "+t );
                listener.onPostExecute("fail", false);
            }
        });
    }
    public interface ApiResultListener {
        void onPreExecute();
        void onPostExecute(String data, boolean isReqSuccess);
    }*/
}
