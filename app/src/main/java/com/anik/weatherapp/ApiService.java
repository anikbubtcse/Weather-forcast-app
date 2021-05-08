package com.anik.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather?appid=92756c24107bc39dd0a7541f66ba55c5&units=metric")
    Call<WeatherData> getWeatherData(@Query("q") String name);
}
