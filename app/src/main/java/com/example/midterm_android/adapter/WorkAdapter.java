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

import com.example.midterm_android.R;
import com.example.midterm_android.model.Work;
import com.example.midterm_android.view.WorkDetailActivity;

import java.util.ArrayList;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Work> worksList;

    public WorkAdapter(Context context, ArrayList<Work> worksList) {
        this.context = context;
        this.worksList = worksList;
    }

    @NonNull
    @Override
    public WorkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gán View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_work, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkAdapter.ViewHolder holder, int position) {
        // Gán dữ liệu
        Work work = worksList.get(position);

        holder.tvName.setText(work.getName());
        holder.tvStar.setText(String.valueOf(work.getStars()));
        holder.tvDescription.setText(work.getDescription());
        holder.ivAvatar.setImageResource(work.getImageResourceID());
        holder.layoutWorkItem.setOnClickListener(v -> {
            onClickDetailWork(work);
        });
    }

    private void onClickDetailWork(Work work) {
        Intent intent = new Intent(context, WorkDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("work", work);
        bundle.putInt("position", worksList.indexOf(work));
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }

    @Override
    public int getItemCount() {
        if (worksList != null) {
            return worksList.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescription;
        TextView tvStar;
        ConstraintLayout layoutWorkItem;
        ImageView ivAvatar;

        ImageView ivMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvStar = itemView.findViewById(R.id.tv_stars);
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

            layoutWorkItem = itemView.findViewById(R.id.single_work_layout);
        }
    }
}
