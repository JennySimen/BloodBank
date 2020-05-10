package com.example.cressence.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private Context mCtx;
    private List<Notification> notificationList;

    public NotificationAdapter(Context mCtx, List<Notification> notificationList) {
        this.mCtx = mCtx;
        this.notificationList = notificationList;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.notify, null);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

        Notification product = notificationList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewInfo.setText(product.getInfo());
        holder.textViewCity.setText(String.valueOf(product.getCity()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewInfo, textViewCity, textViewPrice;

        public NotificationViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.status);
            textViewInfo = itemView.findViewById(R.id.message);
            textViewCity = itemView.findViewById(R.id.city);
            textViewPrice = itemView.findViewById(R.id.price);
        }
    }

}
