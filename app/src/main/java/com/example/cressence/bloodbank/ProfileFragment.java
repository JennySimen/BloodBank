package com.example.cressence.bloodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView bloodType, Username, Email;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstances) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


            bloodType = (TextView) getView().findViewById(R.id.textViewblood);
            Username = (TextView) getView().findViewById(R.id.textViewUsername);
            Email = (TextView) getView().findViewById(R.id.textViewEmail);


       return view;
    }


}
