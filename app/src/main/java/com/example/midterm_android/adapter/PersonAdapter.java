package com.example.midterm_android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm_android.MainActivity;
import com.example.midterm_android.R;
import com.example.midterm_android.model.Person;
import com.example.midterm_android.view.WorkDetailActivity;
import com.example.midterm_android.view.WorksListActivity;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Person> personsList;

    public PersonAdapter(Context context, ArrayList<Person> personsList) {
        this.context = context;
        this.personsList = personsList;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gán View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        // Gán dữ liệu
        Person person = personsList.get(position);

        holder.tvName.setText(person.getName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
        if (person.isGender()) {
            holder.ivGender.setImageResource(R.drawable.male_black_24dp);
        } else {
            holder.ivGender.setImageResource(R.drawable.female_black_24dp);
        }
        holder.tvDescription.setText(person.getDescription());

        holder.ivAvatar.setImageResource(person.getImageResourceID());
        holder.layoutPersonItem.setOnClickListener(v -> {
            onClickPerson(person);
        });
    }

    private void onClickPerson(Person person) {
        Intent intent = new Intent(context, WorksListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", person);
        bundle.putInt("id", person.getId());
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }

    @Override
    public int getItemCount() {
        if (personsList != null) {
            return personsList.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;
        ImageView ivGender;
        TextView tvDescription;
        ConstraintLayout layoutPersonItem;

        ImageView ivAvatar;
        ImageView ivMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            ivGender = itemView.findViewById(R.id.iv_gender);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);

            ivMark = itemView.findViewById(R.id.iv_mark);
            ivMark.setTag("unmarked");
            ivMark.setOnClickListener(v -> {
                if (ivMark.getTag().equals("unmarked")) {
                    ivMark.setImageResource(R.drawable.favorite_black_36dp);
                    ivMark.setTag("marked");
                } else {
                    ivMark.setImageResource(R.drawable.favorite_border_black_36dp);
                    ivMark.setTag("unmarked");
                }
            });

            layoutPersonItem = itemView.findViewById(R.id.single_person_layout);
        }
    }
}
