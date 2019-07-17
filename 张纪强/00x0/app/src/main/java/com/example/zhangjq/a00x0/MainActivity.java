package com.example.zhangjq.a00x0;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> tab_title_list = new ArrayList<>();//存放标签页标题
    private ArrayList<Fragment> fragment_list = new ArrayList<>();//存放ViewPager下的Fragment
    private Fragment fragment1, fragment2, fragment3, fragment4, fragment5,fragment6,fragment7,fragment8,fragment9;
    private MyFragmentPagerAdapter adapter;//适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //etSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.t1_tabs);
        viewPager = (ViewPager) findViewById(R.id.vp_content);
        tab_title_list.add("页面1");
        tab_title_list.add("页面2");
        tab_title_list.add("页面3");
        tab_title_list.add("页面4");
        tab_title_list.add("页面5");
        tab_title_list.add("页面6");
        tab_title_list.add("页面7");
        tab_title_list.add("页面8");
        tab_title_list.add("页面9");
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(6)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(7)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(8)));
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        fragment6 = new Fragment6();
        fragment7 = new Fragment7();
        fragment8 = new Fragment8();
        fragment9 = new Fragment9();
        fragment_list.add(fragment1);
        fragment_list.add(fragment2);
        fragment_list.add(fragment3);
        fragment_list.add(fragment4);
        fragment_list.add(fragment5);
        fragment_list.add(fragment6);
        fragment_list.add(fragment7);
        fragment_list.add(fragment8);
        fragment_list.add(fragment9);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), tab_title_list, fragment_list);
        viewPager.setAdapter(adapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout与Viewpager联动起来
        tabLayout.setTabsFromPagerAdapter(adapter);//给TabLayout设置适配器
    }

}
