package com.example.cressence.bloodbank;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TipViewHolder extends RecyclerView.ViewHolder {

    public TextView mTitle;

    public TipViewHolder(View itemView, TextView mTitle) {
        super(itemView);
        this.mTitle = mTitle;
    }
    public TipViewHolder(View itemView) {
        super(itemView);
        mTitle= (TextView)itemView.findViewById(R.id.title);

    }


}
