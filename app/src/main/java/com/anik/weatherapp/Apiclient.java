package com.anik.weatherapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }

}
