package com.example.is_mobile.laptop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.is_mobile.R;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {
    @Setter
    @Getter
    private List<LaptopMetrics> laptopMetricsList;

    LaptopAdapter() {
        this.laptopMetricsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laptop, parent, false);
        LaptopViewHolder vh = new LaptopViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {

        holder.name.setText(laptopMetricsList.get(position).getName());
        holder.id.setText(laptopMetricsList.get(position).getId().toString());

    }

    @Override
    public int getItemCount() {
        return laptopMetricsList.size();
    }

    class LaptopViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;

        LaptopViewHolder(@NonNull View v) {
            super(v);
            id = v.findViewById(R.id.laptop_id);
            name = v.findViewById(R.id.laptop_name);
        }
    }

}
