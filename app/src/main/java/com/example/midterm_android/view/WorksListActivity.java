package com.example.midterm_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.midterm_android.R;
import com.example.midterm_android.adapter.WorkAdapter;
import com.example.midterm_android.databinding.ActivityWorksListBinding;
import com.example.midterm_android.model.Work;

import java.util.ArrayList;

public class WorksListActivity extends AppCompatActivity {

    private ActivityWorksListBinding binding;
    private ArrayList<Work> works;
    private WorkAdapter workAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorksListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        works = new ArrayList<>();
        binding.progressBarWorkList.setVisibility(View.GONE);
        addWorks();

        workAdapter = new WorkAdapter(WorksListActivity.this, works);
        binding.rvWork.setAdapter(workAdapter);
        binding.rvWork.setHasFixedSize(true);
    }

    private void addWorks () {
        works.add(new Work("Tác phẩm 1", "Rất hay 1", 3, R.drawable.sach1, 1));
        works.add(new Work("Tác phẩm 2", "Rất hay 2", 3, R.drawable.sach2, 1));
        works.add(new Work("Tác phẩm 3", "Rất hay 3", 3, R.drawable.sach3, 1));
        works.add(new Work("Tác phẩm 4", "Rất hay 4", 3, R.drawable.sach4, 1));
        works.add(new Work("Tác phẩm 5", "Rất hay 5", 3, R.drawable.sach5, 2));
        works.add(new Work("Tác phẩm 1", "Rất hay 1", 3, R.drawable.sach1, 2));
        works.add(new Work("Tác phẩm 2", "Rất hay 2", 3, R.drawable.sach2, 2));
        works.add(new Work("Tác phẩm 3", "Rất hay 3", 3, R.drawable.sach3, 2));
        works.add(new Work("Tác phẩm 4", "Rất hay 4", 3, R.drawable.sach4, 2));
        works.add(new Work("Tác phẩm 5", "Rất hay 5", 3, R.drawable.sach5, 3));
        works.add(new Work("Tác phẩm 1", "Rất hay 1", 3, R.drawable.sach1, 3));
        works.add(new Work("Tác phẩm 2", "Rất hay 2", 3, R.drawable.sach2, 3));
        works.add(new Work("Tác phẩm 3", "Rất hay 3", 3, R.drawable.sach3, 3));
        works.add(new Work("Tác phẩm 4", "Rất hay 4", 3, R.drawable.sach4, 3));
        works.add(new Work("Tác phẩm 5", "Rất hay 5", 3, R.drawable.sach5, 4));
        works.add(new Work("Tác phẩm 1", "Rất hay 1", 3, R.drawable.sach1, 4));
        works.add(new Work("Tác phẩm 2", "Rất hay 2", 3, R.drawable.sach2, 4));
        works.add(new Work("Tác phẩm 3", "Rất hay 3", 3, R.drawable.sach3, 4));
        works.add(new Work("Tác phẩm 4", "Rất hay 4", 3, R.drawable.sach4, 4));
        works.add(new Work("Tác phẩm 5", "Rất hay 5", 3, R.drawable.sach5, 5));
        works.add(new Work("Tác phẩm 1", "Rất hay 1", 3, R.drawable.sach1, 5));
        works.add(new Work("Tác phẩm 2", "Rất hay 2", 3, R.drawable.sach2, 5));
        works.add(new Work("Tác phẩm 3", "Rất hay 3", 3, R.drawable.sach3, 5));
        works.add(new Work("Tác phẩm 4", "Rất hay 4", 3, R.drawable.sach4, 5));
        works.add(new Work("Tác phẩm 5", "Rất hay 5", 3, R.drawable.sach5, 5));
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.progressBarWorkList.setVisibility(View.GONE);
    }
}