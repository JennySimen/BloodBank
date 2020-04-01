package com.example.cressence.bloodbank;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

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
                    case R.id.action_profile:
                        selectedfragment = ProfileFragment.newInstance();
                        break;
                    case R.id.action_hospital:
                        selectedfragment = HospitalFragment.newInstance();
                        break;
                    case R.id.action_history:
                        Toast.makeText(UserActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_home:
                        selectedfragment = HomeFragment.newInstance();
                        break;
                    case  R.id.action_notification:
                       selectedfragment = NotificationFragment.newInstance();
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
}
