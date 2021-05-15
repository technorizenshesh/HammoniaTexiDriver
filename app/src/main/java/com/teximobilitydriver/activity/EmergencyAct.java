package com.teximobilitydriver.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.teximobilitydriver.R;
import com.teximobilitydriver.adapter.AdapterEmergency;
import com.teximobilitydriver.databinding.ActivityEmergencyBinding;

public class EmergencyAct extends AppCompatActivity {
    ActivityEmergencyBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_emergency);
        initView();
    }

    private void initView() {
        binding.header.tvTitle.setText(getString(R.string.emergency));
        binding.header.ivBack.setOnClickListener(v -> {finish();});

        Toast.makeText(this, getString(R.string.you_can_add_up_to_five), Toast.LENGTH_SHORT).show();

        binding.rvEmergency.setAdapter(new AdapterEmergency(EmergencyAct.this));
    }
}
