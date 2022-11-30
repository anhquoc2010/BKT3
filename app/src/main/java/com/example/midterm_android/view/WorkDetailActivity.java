package com.example.midterm_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.midterm_android.R;
import com.example.midterm_android.adapter.GalleryAdapter;
import com.example.midterm_android.databinding.ActivityWorkDetailBinding;
import com.example.midterm_android.model.Work;

import java.util.ArrayList;

public class WorkDetailActivity extends AppCompatActivity {

    ActivityWorkDetailBinding binding;
    ArrayList<Integer> images;
    GalleryAdapter galleryAdapter;
    Work work;
    Bundle bundle;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        binding = ActivityWorkDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundle();
        addGallery();

        galleryAdapter = new GalleryAdapter(this, images);
        binding.rvWorkGallery.setAdapter(galleryAdapter);
        binding.rvWorkGallery.setHasFixedSize(true);

        binding.ibBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void getBundle() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            position = bundle.getInt("position");
            work = (Work) bundle.getSerializable("work");
            binding.tvWorkName.setText(work.getName());
            binding.tvWorkDescription.setText(work.getDescription());
            binding.ivBackgroundWorkDetail.setImageResource(work.getImageResourceID());
        }
    }

    private void addGallery() {
        images = new ArrayList<>();
        images.add(R.drawable.pet1);
        images.add(R.drawable.pet2);
        images.add(R.drawable.pet3);
        images.add(R.drawable.pet4);
        images.add(R.drawable.pet3);
        images.add(R.drawable.pet4);
        images.add(R.drawable.pet3);
        images.add(R.drawable.pet1);
        images.add(R.drawable.pet5);
    }
}