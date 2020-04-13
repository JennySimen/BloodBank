package com.example.cressence.bloodbank;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReclyclerViewAdapter extends RecyclerView.Adapter<ReclyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Hospital> mData;
    Dialog myDialog;

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

        //dialog ini
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_booking);

        vHolder.item_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dailog_name_tv = (TextView) myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_address_tv = (TextView) myDialog.findViewById(R.id.dialog_address_id);
                ImageView dialog_image_tv = (ImageView) myDialog.findViewById(R.id.dialog_img_id);

                dailog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_address_tv.setText(mData.get(vHolder.getAdapterPosition()).getCity());
                dialog_image_tv.setImageResource(mData.get(vHolder.getAdapterPosition()).getImage());

                Toast.makeText(mContext,"Test click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

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

        private LinearLayout item_hospital;

        private TextView tv_city;
        private TextView tv_name;
        private ImageView tv_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_hospital = (LinearLayout) itemView.findViewById(R.id.hospital_item_id);

            tv_city = (TextView) itemView.findViewById(R.id.city);
            tv_name = (TextView) itemView.findViewById(R.id.clinic);
            tv_img = (ImageView) itemView.findViewById(R.id.img);
        }
    }




}
