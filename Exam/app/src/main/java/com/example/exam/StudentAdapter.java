package com.example.exam;

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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> implements Filterable {
    private ArrayList<Student> listStudent;
    private ClickListener activity;
    private ArrayList<Student> filter;

    public StudentAdapter(Context context, ArrayList<Student> listStudent) {
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
                    ArrayList<Student> filteredList = new ArrayList<>();
                    for (Student row : listStudent) {

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
                filter = (ArrayList<Student>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public interface ClickListener{
        public void setOnClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvId;
        ImageView ivAvatar;
        CheckBox cbDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);

            cbDelete = itemView.findViewById(R.id.cbDelete);

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
//        holder.tvName.setTag(listStudent.get(position).getName());
        holder.cbDelete.setOnCheckedChangeListener(null);
        holder.cbDelete.setChecked(listStudent.get(position).isSelected());
        holder.cbDelete.setTag(listStudent.get(position));

        holder.cbDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    listStudent.get(position).setSelected(true);
                }
                else{
                    listStudent.get(position).setSelected(false);
                }
            }
        });

        holder.tvName.setText(listStudent.get(position).getName());
        holder.tvId.setText(listStudent.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return listStudent==null?0:listStudent.size();
    }
}
