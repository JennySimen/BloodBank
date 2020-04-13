package com.example.cressence.bloodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HospitalFragment extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Hospital> listHospital;

    public static HospitalFragment newInstance() {
        HospitalFragment fragment = new HospitalFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHospital = new ArrayList<>();
        listHospital.add(new Hospital("Douala", "General Hospital Douala", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Yaounde", "General Hospital Yaounde",R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Buea", "General Hospital Buea", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Limbe", "General Hospital Limbe", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Bafoussam", "General Hospital Bafoussam", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Douala", "laquintinie", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Douala", "General Hospital Douala",R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Yaounde", "General Hospital Yaounde", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Buea", "General Hospital Buea", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Limbe", "General Hospital Limbe", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Bafoussam", "General Hospital Bafoussam", R.drawable.ic_place_black_24dp));
        listHospital.add(new Hospital("Douala", "laquintinie",R.drawable.ic_place_black_24dp));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstances) {
        v = inflater.inflate(R.layout.fragment_hospital, container, false);

        myRecyclerView = (RecyclerView) v.findViewById(R.id.hospital);
        ReclyclerViewAdapter reclyclerViewAdapter = new ReclyclerViewAdapter(getContext(),listHospital);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(reclyclerViewAdapter);

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(myRecyclerView.getContext(),
//                DividerItemDecoration.VERTICAL);
//        myRecyclerView.addItemDecoration(dividerItemDecoration);

        return v;
    }


}
