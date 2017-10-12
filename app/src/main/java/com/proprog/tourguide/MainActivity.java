package com.proprog.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup view pager for navigate between Places
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        TourPagerAdapter adapter = new TourPagerAdapter(getSupportFragmentManager(),this);
        pager.setAdapter(adapter);

        //setup tablayout with view pager to indicate what is category showing now
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

    }
}
