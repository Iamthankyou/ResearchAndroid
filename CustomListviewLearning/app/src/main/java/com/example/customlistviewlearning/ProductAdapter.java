package com.example.customlistviewlearning;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> listProduct;

    public ProductAdapter(@NonNull Context context, int resource, ArrayList<Product> listProduct) {
        super(context, resource,listProduct);
        this.context = context;
        this.listProduct = listProduct;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.row_layout,null);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDes = (TextView) rowView.findViewById(R.id.tvDescription);
        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivProduct);

        tvProduct.setText(listProduct.get(position).getProduct());
        tvDes.setText(listProduct.get(position).getDes());
        tvPrice.setText(listProduct.get(position).getPrice());

        if (listProduct.get(position).isSale()){
            ivSale.setImageResource(R.mipmap.on_sale_big);
        }
        else{
            ivSale.setImageResource(R.mipmap.best_price);
        }

        if (listProduct.get(position).getProduct().equals("laptop")){
            ivProduct.setImageResource(R.mipmap.laptop);
        }
        else if (listProduct.get(position).getProduct().equals("hdd")){
            ivProduct.setImageResource(R.mipmap.hdd);
        }
        else if (listProduct.get(position).getProduct().equals("memory")){
            ivProduct.setImageResource(R.mipmap.memory);
        }
        else{
            ivProduct.setImageResource(R.mipmap.screen);
        }

        return rowView;
    }
}
