package com.example.lequangduy_181203460;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_181203460 extends RecyclerView.Adapter<Adapter_181203460.ViewHolder> implements Filterable {
    private ArrayList<Taxi_LeQuangDuy> list;
    private ClickListener clickListener;
    private ArrayList<Taxi_LeQuangDuy> filter;
    int pos;

    private ClickListener activity;

    public interface ClickListener{
        public void setOnClickListener(int position);
        public void setOnLong(int position);
    }

    public Adapter_181203460(Context context, ArrayList<Taxi_LeQuangDuy> list) {
        this.list = list;
        activity = (ClickListener) context;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filter = list;
                    System.out.println("Empty");
                } else {
                    ArrayList<Taxi_LeQuangDuy> filteredList = new ArrayList<>();
                    for (Taxi_LeQuangDuy row : list) {

//                        if (row.getColumnString().toLowerCase().contains(charString.toLowerCase())) {
//                            filteredList.add(row);
//                            System.out.print("OK");
//                        }
                    }

                    filter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (ArrayList<Taxi_LeQuangDuy>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

//    public interface ClickListener{
//        public void setOnClickListener(int position);
//    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView row_soxe, row_quangduong, row_id, row_tongtien;
        ImageView ivAvatar;
        //        CheckBox cbDelete;
        Switch cbDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            row_soxe = itemView.findViewById(R.id.tvSoXe);
            row_quangduong = itemView.findViewById(R.id.tvQuangDuong);
            row_tongtien = itemView.findViewById(R.id.tvTongTien);

//            cbDelete = itemView.findViewById(R.id.row_switch);

            itemView.setOnClickListener(v -> {
                activity.setOnClickListener(list.indexOf(itemView.getTag()));
            });

            itemView.setOnLongClickListener(v->{
                activity.setOnLong(list.indexOf(itemView.getTag()));
                return false;
            });

            itemView.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem edit = menu.add(Menu.NONE,1,1,"Xóa");
            MenuItem delete = menu.add(Menu.NONE,2,2,"Sửa");

            edit.setOnMenuItemClickListener(onChange);
            delete.setOnMenuItemClickListener(onChange);
        }

        private final MenuItem.OnMenuItemClickListener onChange = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case 1:

                        new AlertDialog.Builder(itemView.getContext())
                                .setTitle("Xóa mục này")
                                .setMessage("Bạn có chắc chắn muốn xóa mục này ?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Continue with delete operation
                                        System.out.println("Click 1" + row_soxe.getText().toString());
                                        Application.delele(Integer.parseInt(row_id.getText().toString()));
                                        notifyDataSetChanged();
                                        list = Application.list;

                                    }
                                })

                                .setNegativeButton(android.R.string.no, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                        //
                        return true;
                    case 2:
                        System.out.println("Click 2" + pos);
//
//                        Intent intent = new Intent (itemView.getContext(), Detail.class);
//                        intent.putExtra("id", getPosition());
//
//                        itemView.getContext().startActivity(intent);

                        return true;
                }
                return false;
            }
        };

    }

    @NonNull
    @Override
    public Adapter_181203460.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycle_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_181203460.ViewHolder holder, int position) {
        holder.itemView.setTag(list.get(position));
//        holder.tvName.setTag(list.get(position).getName());
//        holder.cbDelete.setOnCheckedChangeListener(null);
//        holder.cbDelete.setChecked(list.get(position).isColumnBoolean()==1);
//        holder.cbDelete.setTag(list.get(position));
//        pos = position;

//        System..println(list.get(position).getColumnString() + " " + list.get(position).isColumnBoolean());

//        holder.cbDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                if (isChecked){
////                    list.get(position).setColumnBoolean(1);
////                }
////                else{
////                    list.get(position).setColumnBoolean(0);
////                }
//            }
//        });


        holder.row_soxe.setText(list.get(position).getSoXe());
        holder.row_quangduong.setText("Quãng đường: " + String.valueOf(list.get(position).getQuangDuong()));
        double res = (list.get(position).getDonGia() * list.get(position).getQuangDuong() * (100 - list.get(position).getKhuyenMai())/100);
        holder.row_tongtien.setText(String.valueOf(res));
//        holder.row_id.setText(String.valueOf(list.get(position).getColumnInt()));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}

