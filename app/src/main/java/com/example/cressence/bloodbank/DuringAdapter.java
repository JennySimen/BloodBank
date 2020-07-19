package com.example.cressence.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DuringAdapter extends RecyclerView.Adapter<DuringViewHolder>{

    private Context dContext;
    private List<assistant_info> infos2;

    public DuringAdapter(Context dContext, List<assistant_info> infos2) {
        this.dContext = dContext;
        this.infos2 = infos2;
    }


    @NonNull
    @Override
    public DuringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(dContext).inflate(R.layout.item_during, parent, false);
        return new DuringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuringViewHolder holder, int position) {
        assistant_info info = infos2.get(position);
        holder.dTitle.setText(info.getTip());

    }

    @Override
    public int getItemCount() {
        return infos2.size();
    }
}


