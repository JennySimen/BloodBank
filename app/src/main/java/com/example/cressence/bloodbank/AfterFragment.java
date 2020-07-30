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

public class AfterFragment extends Fragment {

    public static AfterFragment newInstance() {
        AfterFragment fragment = new AfterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.after, container, false);

        RecyclerView afterRecyclerView = (RecyclerView) view.findViewById(R.id.after_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        afterRecyclerView.setLayoutManager(linearLayoutManager);
        afterRecyclerView.setHasFixedSize(true);
        AssistantAdapter aAdapter = new AssistantAdapter(getActivity(), getData());
        afterRecyclerView.setAdapter(aAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(afterRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        afterRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    public List<assistant_info> getData() {
        List<assistant_info> afterTips = new ArrayList<assistant_info>();
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        afterTips.add(new assistant_info("Eat a lot of fruits"));
        return afterTips;
    }
}
