package com.example.is_mobile.laptop;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.is_mobile.R;

import java.util.List;

public class LaptopListActivity extends AppCompatActivity {
    public static final String LAPTOP_ID = "laptop_id";
    private LaptopViewModel laptopViewModel;
    private LaptopAdapter laptopAdapter;
    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_list);
        laptopViewModel = new LaptopViewModel();
        laptopAdapter = new LaptopAdapter();
        initRecycler();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recyclerView_laptops);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(laptopAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, (view, position) -> {
            Long laptopId = laptopAdapter.getLaptopMetricsList().get(position).getId();
            Intent laptopDetails = new Intent(this, LaptopDetailsActivity.class);
            laptopDetails.putExtra(LAPTOP_ID, laptopId);
            startActivity(laptopDetails);
        }));
    }


    @Override
    protected void onStart() {
        super.onStart();
        laptopViewModel.getLaptops()
                .observe(this, list -> onChanged(list));
    }

    private void onChanged(List<LaptopMetrics> list) {
        laptopAdapter.setLaptopMetricsList(list);
        laptopAdapter.notifyDataSetChanged();
    }


}
