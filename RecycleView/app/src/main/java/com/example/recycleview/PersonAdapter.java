package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> listPerson;
   private ItemClicked activity;

    public PersonAdapter(Context context, ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
        activity = (ItemClicked) context;
    }

    public interface ItemClicked{
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView tvName, tvYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            tvName = itemView.findViewById(R.id.tvName);
            tvYear = itemView.findViewById(R.id.tvYear);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClick(listPerson.indexOf((Person)v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(listPerson.get(position));

        holder.tvName.setText(listPerson.get(position).getName());
        holder.tvYear.setText(listPerson.get(position).getYear());

        if (listPerson.get(position).getYear().equals("img1")){
            holder.imgView.setImageResource(R.drawable.img1);
        }
        else{
            holder.imgView.setImageResource(R.drawable.img1);
        }
    }

    @Override
    public int getItemCount() {
        return listPerson.size();
    }
}
