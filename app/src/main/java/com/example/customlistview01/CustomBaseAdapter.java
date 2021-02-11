package com.example.customlistview01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter implements Filterable {
    private Context context; //context
    private ArrayList<Student> dsSinhVien; //data source of the list adapter

    private ArrayList<Student> filterList;

    private CustomFilter filter;

    private class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint!=null && constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                ArrayList<Student> filters = new ArrayList<>();

                for (int i=0; i<filterList.size(); i++){
                    if (filters.get(i).getName().toUpperCase().contains(constraint)) {
                        Student s = new Student(filters.get(i).getName(),filters.get(i).getBirthday());
                        filters.add(s);
                    }
                }

                results.count = filterList.size();
                results.values = filters;
            }
            else{
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dsSinhVien = (ArrayList<Student>)results.values;
            notifyDataSetChanged();
        }
    }

    public CustomBaseAdapter(Context context, ArrayList<Student> dsSinhVien) {
        this.context = context;
        this.dsSinhVien = dsSinhVien;
        this.filterList = dsSinhVien;
    }

    @Override
    public int getCount() {
        return dsSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return dsSinhVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        View view = convertView;

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.activity_custom_list_view,null);
        }

        Student s = (Student)getItem(pos);

        if (s!=null){
            TextView tx1 = (TextView)view.findViewById(R.id.textView);
            TextView tx2 = (TextView)view.findViewById(R.id.birthday);
            tx1.setText(s.getName());
            tx2.setText(String.valueOf(s.getBirthday()));
        }

        return view;
    }

    @Override
    public Filter getFilter() {

        if (filter == null){
            filter = new CustomFilter();
        }

        return filter;
    }
}
