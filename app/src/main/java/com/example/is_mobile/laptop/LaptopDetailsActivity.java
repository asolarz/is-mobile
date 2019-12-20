package com.example.is_mobile.laptop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.is_mobile.R;
import com.example.is_mobile.databinding.ActivityLaptopDetailsBinding;

import static com.example.is_mobile.laptop.LaptopListActivity.LAPTOP_ID;

public class LaptopDetailsActivity extends AppCompatActivity {
    private LaptopSpecificationViewModel laptopSpecificationViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityLaptopDetailsBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_laptop_details);
        Long laptopId = (Long) getIntent().getExtras().getSerializable(LAPTOP_ID);
        laptopSpecificationViewModel = new LaptopSpecificationViewModel();
        laptopSpecificationViewModel.getLaptop(laptopId).observe(this, laptopSpecification ->
                viewDataBinding.setLaptop(laptopSpecification));

    }
}
