package com.example.cressence.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssistantAdapter extends RecyclerView.Adapter<TipViewHolder>{
        private Context context;
        private List<assistant_info> infos;

        public AssistantAdapter(Context context, List<assistant_info> infos) {
            this.context = context;
            this.infos = infos;
        }

        @Override
        public TipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.assistant_recycler_item, parent, false);
            return new TipViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull TipViewHolder holder, int position) {
        assistant_info info = infos.get(position);
        holder.mTitle.setText(info.getTip());
    }

        @Override
        public int getItemCount() {
            return infos.size();
        }
    }

