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

public class BeforeFragment extends Fragment {


    public static BeforeFragment newInstance() {
        BeforeFragment fragment = new BeforeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.before, container, false);

        RecyclerView songRecyclerView = (RecyclerView) view.findViewById(R.id.before_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        songRecyclerView.setLayoutManager(linearLayoutManager);
        songRecyclerView.setHasFixedSize(true);
        AssistantAdapter mAdapter = new AssistantAdapter(getActivity(), getTestData());
        songRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(songRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        songRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    public List<assistant_info> getTestData() {
        List<assistant_info> recentTips = new ArrayList<assistant_info>();
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        recentTips.add(new assistant_info("Get some good sleep"));
        return recentTips;
    }

}
