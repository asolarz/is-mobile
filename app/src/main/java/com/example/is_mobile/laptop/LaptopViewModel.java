package com.example.is_mobile.laptop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.is_mobile.AppConfiguration.BASE_URL;


public class LaptopViewModel extends ViewModel {
    private MutableLiveData<List<LaptopMetrics>> laptopMetricsMutableLiveData;

    public LaptopViewModel() {
    }

    LiveData<List<LaptopMetrics>> getLaptops() {
        if (laptopMetricsMutableLiveData == null)
            laptopMetricsMutableLiveData = new MutableLiveData<>();
        loadData();
        return laptopMetricsMutableLiveData;

    }

    private void loadData() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LaptopAPI laptopAPI = retrofit.create(LaptopAPI.class);
        laptopAPI.laptops().enqueue(new Callback<List<LaptopMetrics>>() {
            @Override
            public void onResponse(Call<List<LaptopMetrics>> call, Response<List<LaptopMetrics>> response) {
                laptopMetricsMutableLiveData.setValue(response
                        .body()
                        .stream()
                        .sorted(Comparator.comparing(LaptopMetrics::getId))
                        .collect(Collectors.toList()));

            }

            @Override
            public void onFailure(Call<List<LaptopMetrics>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
