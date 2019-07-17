package com.example.test233;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    ArrayList<String> titles;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
         for(i = 0;i<10;i++)
         {

             titles.add("第"+i+"项");
             fragments.add(MyFragment.getInstance("第"+i+"个页面"));
         }
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),fragments,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        }

    }
