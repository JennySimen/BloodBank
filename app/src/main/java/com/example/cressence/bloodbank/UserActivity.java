package com.example.cressence.bloodbank;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;

                switch (item.getItemId()) {
//                    case R.id.action_profile:
//                        selectedfragment = ProfileFragment.newInstance();
//                        break;
                    case R.id.action_hospital:
                        selectedfragment = HospitalFragment.newInstance();
                        break;
                    case R.id.action_appointment:
                       selectedfragment = AppointmentFragment.newInstance();
                        break;
                    case R.id.action_home:
                        selectedfragment = HomeFragment.newInstance();
                        break;
                    case  R.id.action_notification:
                       selectedfragment = NotificationFragment.newInstance();
                        break;
                    case  R.id.action_assistant:
                        selectedfragment = AssistantFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedfragment);
                transaction.commit();
                return true;
            }
        });
        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, HomeFragment.newInstance());
        transaction.commit();

    }

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item2) {
        switch (item2.getItemId()) {
            case R.id.share:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                String shareSubject = "Title";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }
        return super.onOptionsItemSelected(item2);
    }
}
