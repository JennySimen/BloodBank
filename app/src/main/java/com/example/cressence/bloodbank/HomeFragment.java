package com.example.cressence.bloodbank;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    TextView donate, health, more;

        public static HomeFragment newInstance() {
            HomeFragment fragment = new HomeFragment();
            return fragment;
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstances) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView donate = view.findViewById(R.id.info);
        donate.setMovementMethod(LinkMovementMethod.getInstance());

        TextView health = view.findViewById(R.id.info2);
        health.setMovementMethod(LinkMovementMethod.getInstance());

        TextView more = view.findViewById(R.id.more);
        more.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
