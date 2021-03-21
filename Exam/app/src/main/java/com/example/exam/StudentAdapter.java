package com.example.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> listStudent;
    private ClickListener activity;

    public StudentAdapter(Context context, ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
        activity = (ClickListener) context;
    }

    public interface ClickListener{
        public void setOnClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvBirthday,tvClass;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvBirthday = itemView.findViewById(R.id.tvBirthday);
            tvClass = itemView.findViewById(R.id.tvClass);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);

            itemView.setOnClickListener(v->{
                activity.setOnClickListener(listStudent.indexOf(itemView.getTag()));
            });

        }
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycle_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(listStudent.get(position));

        holder.tvClass.setText(listStudent.get(position).getNameClass());
        holder.tvName.setText(listStudent.get(position).getName());
        holder.tvBirthday.setText(listStudent.get(position).getBirthday());
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }
}
