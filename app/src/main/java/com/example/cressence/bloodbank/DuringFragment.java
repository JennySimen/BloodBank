package com.example.cressence.bloodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DuringFragment extends Fragment {

    public static DuringFragment newInstance() {
        DuringFragment fragment = new DuringFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.during, container, false);

        RecyclerView duringRecyclerView = (RecyclerView) view.findViewById(R.id.during_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        duringRecyclerView.setLayoutManager(linearLayoutManager);
        duringRecyclerView.setHasFixedSize(true);
        DuringAdapter mAdapter = new DuringAdapter(getActivity(), getDummyData());
        duringRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(duringRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        duringRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    public List<assistant_info> getDummyData() {
        List<assistant_info> duringTips = new ArrayList<assistant_info>();
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        duringTips.add(new assistant_info("Listen to some music"));
        return duringTips;
    }
}
