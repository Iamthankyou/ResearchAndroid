package com.example.recycleviewwithfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> listPerson;
    private ClickListener activity;

    public interface ClickListener{
        public void setOnClickListener(int position);
    }

    public PersonAdapter(Context context, ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
        activity = (ClickListener) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvPieceName);

            itemView.setOnClickListener(v -> {
                activity.setOnClickListener(listPerson.indexOf(itemView.getTag()));
            });

        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(listPerson.get(position));
        holder.tvName.setText(listPerson.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listPerson.size();
    }
}
