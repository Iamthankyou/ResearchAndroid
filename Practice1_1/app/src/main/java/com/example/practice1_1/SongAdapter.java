package com.example.practice1_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> implements Filterable {
    private ArrayList<Song> listStudent;
    private ClickListener activity;
    private ArrayList<Song> filter;

    public SongAdapter(Context context, ArrayList<Song> listStudent) {
        this.listStudent = listStudent;
        activity = (ClickListener) context;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filter  = listStudent;
                } else {
                    ArrayList<Song> filteredList = new ArrayList<>();
                    for (Song row : listStudent) {

                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    filter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filter = (ArrayList<Song>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public interface ClickListener{
        public void setOnClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvTime,tvSinger;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvSinger = itemView.findViewById(R.id.tvSinger);

            itemView.setOnClickListener(v->{
                activity.setOnClickListener(listStudent.indexOf(itemView.getTag()));
            });

        }
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycle_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(listStudent.get(position));
//        holder.tvName.setTag(listStudent.get(position).getName());

        holder.tvName.setText(listStudent.get(position).getName());
        holder.tvSinger.setText(listStudent.get(position).getSinger());

        double time = listStudent.get(position).getTime();
        double minute = time/60;
        double second = time%60;
        String timeString = String.valueOf(minute) + ":" + String.valueOf(second);


        holder.tvTime.setText(timeString);

    }

    @Override
    public int getItemCount() {
        return listStudent==null?0:listStudent.size();
    }
}
