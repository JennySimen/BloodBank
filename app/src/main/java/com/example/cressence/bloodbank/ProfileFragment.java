package com.example.cressence.bloodbank;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_CANCELED;
import static androidx.media.MediaBrowserServiceCompat.RESULT_OK;

public class ProfileFragment extends Fragment {

    TextView textViewId, textViewUsername, textViewEmail, textViewGender,textViewBlood;

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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //if the user is not logged in
        //starting the login activity
        if (!PrefManager.getInstance(this.getActivity()).isLoggedIn()) {
//            getActivity().finish();
//           startActivity(new Intent(getContext(), LoginActivity.class));
        }


        textViewId = (TextView) v.findViewById(R.id.textViewId);
        textViewUsername = (TextView) v.findViewById(R.id.textViewUsername);
        textViewEmail = (TextView) v.findViewById(R.id.textViewEmail);
        textViewGender = (TextView) v.findViewById(R.id.textViewGender);
        textViewBlood = (TextView) v.findViewById(R.id.textViewBlood);


        //getting the current user
        User user = PrefManager.getInstance(this.getActivity()).getUser();

        //setting the values to the textviews
        textViewId.setText(String.valueOf(user.getId()));
        textViewUsername.setText(user.getName());
        textViewEmail.setText(user.getEmail());
        textViewGender.setText(user.getLocation());
        textViewBlood.setText(user.getBlood());

        //when the user presses logout button
        //calling the logout method
        v.findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                PrefManager.getInstance(getActivity().getApplicationContext()).logout();
            }
        });

       return v;
    }



}
