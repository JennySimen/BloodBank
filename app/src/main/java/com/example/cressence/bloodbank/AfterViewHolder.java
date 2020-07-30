package com.example.cressence.bloodbank;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AfterViewHolder extends RecyclerView.ViewHolder{

    public TextView aTitle;

    public AfterViewHolder(View itemView, TextView dTitle) {
        super(itemView);
        this.aTitle = aTitle;
    }
    public AfterViewHolder(View itemView) {
        super(itemView);
        aTitle= (TextView)itemView.findViewById(R.id.title3);

    }
}
