package pow.jie.powmoji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import pow.jie.powmoji.adapter.MyPagerAdapter;
import pow.jie.powmoji.fragment.MojiFragment;

public class MainActivity extends AppCompatActivity {

    MyPagerAdapter adapter;
    private List<MojiFragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tb_main);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.vp_main);
        tabLayout = findViewById(R.id.tl_main);

        fragments.add(MojiFragment.newInstance("happy"));
        fragments.add(MojiFragment.newInstance("sad"));
        fragments.add(MojiFragment.newInstance("angry"));
        fragments.add(MojiFragment.newInstance("doubt"));
        titles.add("happy");
        titles.add("sad");
        titles.add("angry");
        titles.add("doubt");

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        adapter.setTitles(titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
