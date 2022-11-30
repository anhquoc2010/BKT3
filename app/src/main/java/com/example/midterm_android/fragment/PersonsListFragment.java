package com.example.midterm_android.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midterm_android.adapter.PersonAdapter;
import com.example.midterm_android.R;
import com.example.midterm_android.databinding.FragmentPersonsListBinding;
import com.example.midterm_android.model.Person;

import java.util.ArrayList;

public class PersonsListFragment extends Fragment {

    private FragmentPersonsListBinding binding;
    private ArrayList<Person> persons;
    private PersonAdapter personAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPersonsListBinding.inflate(inflater, container, false);

        persons = new ArrayList<>();
        binding.progressBarPersonList.setVisibility(View.GONE);
        addPersons();

        personAdapter = new PersonAdapter(getContext(), persons);
        binding.rvPerson.setAdapter(personAdapter);
        binding.rvPerson.setHasFixedSize(true);

        return binding.getRoot();
    }

    private void addPersons() {
        persons.add(new Person(1, "Huy Cận", true, 54, "Văn hay, chữ tốt", R.drawable.pet1));
        persons.add(new Person(2, "Nguyễn Nhật Ánh", true, 60, "Thơ hay, chữ đẹp", R.drawable.pet2));
        persons.add(new Person(3, "Xuân Quỳnh", false, 50, "Đẹp, Hay, giỏi", R.drawable.pet3));
        persons.add(new Person(4, "Tô Hoài", true, 70, "Rất giỏi", R.drawable.pet4));
        persons.add(new Person(5, "Nam Cao", true, 84, "Rất cao", R.drawable.pet5));
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.progressBarPersonList.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.progressBarPersonList.setVisibility(View.GONE);
        //get intent
        if (getActivity().getIntent().getExtras() != null) {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                persons.set(intent.getIntExtra("position", 0), (Person) intent.getSerializableExtra("person"));
            }
            personAdapter.notifyDataSetChanged();
        }
//        Intent intent = getActivity().getIntent();
//        if (intent != null) {
//            persons.set(intent.getIntExtra("position", 0), (Person) intent.getSerializableExtra("person"));
//            personAdapter.notifyDataSetChanged();
//        }
    }
}