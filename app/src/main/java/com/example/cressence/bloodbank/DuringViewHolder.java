package com.example.cressence.bloodbank;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DuringViewHolder extends RecyclerView.ViewHolder {

    public TextView dTitle;

    public DuringViewHolder(View itemView, TextView dTitle) {
        super(itemView);
        this.dTitle = dTitle;
    }
    public DuringViewHolder(View itemView) {
        super(itemView);
        dTitle= (TextView)itemView.findViewById(R.id.title2);

    }
}
