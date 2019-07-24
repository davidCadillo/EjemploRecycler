package com.tecavi.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    private RetrofitClient(){
    }

    public static Retrofit getClient(String url){
       if(retrofit == null){
           Gson gson = new GsonBuilder()
                   .setLenient()
                   .create();

           retrofit = new Retrofit.Builder()
                   .baseUrl(url)
                   .addConverterFactory(GsonConverterFactory.create(gson))
                   .build();
       }

        return retrofit;
    }




}
