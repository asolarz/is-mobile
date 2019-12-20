package com.example.is_mobile.laptop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.is_mobile.AppConfiguration.BASE_URL;

public class LaptopSpecificationViewModel {
    private MutableLiveData<LaptopSpecification> laptopSpecificationMutableLiveData;

    public LaptopSpecificationViewModel() {
    }

    LiveData<LaptopSpecification> getLaptop(Long id) {
        if (laptopSpecificationMutableLiveData == null)
            laptopSpecificationMutableLiveData = new MutableLiveData<>();
        loadData(id);
        return laptopSpecificationMutableLiveData;

    }


    private void loadData(Long id) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LaptopAPI laptopAPI = retrofit.create(LaptopAPI.class);
        laptopAPI.details(id).enqueue(new Callback<LaptopSpecification>() {
            @Override
            public void onResponse(Call<LaptopSpecification> call, Response<LaptopSpecification> response) {
                laptopSpecificationMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LaptopSpecification> call, Throwable t) {
            }
        });
    }

}
