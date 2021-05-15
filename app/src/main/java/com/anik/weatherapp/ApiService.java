package com.anik.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather")
    Call<WeatherData> getWeatherData(@Query("q") String name, @Query("appid") String token,@Query("units") String unit);
}
