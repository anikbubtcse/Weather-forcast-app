package com.anik.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView search;
    private EditText editText;
    private TextView temperature;
    private TextView feelsLike;
    private TextView humidity;
    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                service = Apiclient.getRetrofit().create(ApiService.class);
                Call<WeatherData> call = service.getWeatherData(name);
                call.enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                        if (response.isSuccessful()) {

                            temperature.setText("Temperature"+" "+response.body().getMain().getTemp()+" °C");
                            feelsLike.setText("Feels Like"+" "+response.body().getMain().getFeels_like()+" °C");
                            humidity.setText("Humidity"+" "+response.body().getMain().getHumidity());

                        } else if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Please enter the correct city name!", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

    }

    private void init() {

        search = findViewById(R.id.searchImageviewId);
        editText = findViewById(R.id.editTextId);
        temperature = findViewById(R.id.tempTvId);
        feelsLike = findViewById(R.id.feelsLikeTvId);
        humidity = findViewById(R.id.humidityTvId);
    }
}