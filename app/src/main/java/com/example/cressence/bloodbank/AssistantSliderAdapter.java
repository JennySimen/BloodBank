package com.example.cressence.bloodbank;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AssistantSliderAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public AssistantSliderAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.noOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
               BeforeFragment tab1 = new BeforeFragment();
                return tab1;
            case 1:
              DuringFragment tab2 = new DuringFragment();
                return tab2;
            case 2:
                AfterFragment tab3 = new AfterFragment();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Before";
            case 1:
                return "During";
            case 2:
                return "After";
            default:
                return null;
        }
    }
}
