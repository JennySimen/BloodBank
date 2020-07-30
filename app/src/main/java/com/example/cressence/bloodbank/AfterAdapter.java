package com.example.cressence.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AfterAdapter  extends RecyclerView.Adapter<AfterViewHolder> {

    private Context aContext;
    private List<assistant_info> infos3;

    public AfterAdapter(Context aContext, List<assistant_info> infos3) {
        this.aContext = aContext;
        this.infos3 = infos3;
    }

    @NonNull
    @Override
    public AfterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(aContext).inflate(R.layout.item_after, parent, false);
        return new AfterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AfterViewHolder holder, int position) {
        assistant_info info = infos3.get(position);
        holder.aTitle.setText(info.getTip());

    }

    @Override
    public int getItemCount() {
        return infos3.size();
    }
}
