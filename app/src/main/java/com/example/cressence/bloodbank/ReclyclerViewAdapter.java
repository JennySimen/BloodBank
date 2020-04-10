package com.example.cressence.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReclyclerViewAdapter extends RecyclerView.Adapter<ReclyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Hospital> mData;

    public ReclyclerViewAdapter(Context mContext, List<Hospital> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_hospital, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_city.setText(mData.get(position).getCity());
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_img.setImageResource(mData.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_city;
        private TextView tv_name;
        private ImageView tv_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_city = (TextView) itemView.findViewById(R.id.city);
            tv_name = (TextView) itemView.findViewById(R.id.clinic);
            tv_img = (ImageView) itemView.findViewById(R.id.img);
        }
    }




}
