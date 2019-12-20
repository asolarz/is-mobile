package com.example.is_mobile.laptop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LaptopAPI {
    @GET("/laptops")
    Call<List<LaptopMetrics>> laptops();

    @GET("/laptops/details/{id}")
    Call<LaptopSpecification> details(@Path("id") Long id);
}
