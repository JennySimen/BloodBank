package com.example.cressence.bloodbank;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
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
                switch (item.getItemId()) {
                    case R.id.action_profile:
                        Toast.makeText(UserActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_hospital:
                        Toast.makeText(UserActivity.this, "Hospital", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_history:
                        Toast.makeText(UserActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

}
