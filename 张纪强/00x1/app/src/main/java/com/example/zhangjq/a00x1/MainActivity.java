package com.example.zhangjq.a00x1;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Yang> yangList = new ArrayList<>();
    private YangAdapter adapter;
    private SwipeRefreshLayout SwipeRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initYang();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new YangAdapter(yangList);
        recyclerView.setAdapter(adapter);
        SwipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swiperefresh_layout);
        //SwipeRefresh.setColorSchemeColors(R.color.colorPrimary);



        SwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshYang();
            }
        });

    }
    private void  refreshYang(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initYang();
                        adapter.notifyDataSetChanged();
                        SwipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initYang() {
        yangList.clear();
        for (int i = 0; i < 2; i++) {
            Yang xiyangyang = new Yang("喜羊羊", R.drawable.xiyangyang);
            yangList.add(xiyangyang);
            Yang meiyangyang = new Yang("美羊羊", R.drawable.meiyangyang);
            yangList.add(meiyangyang);
            Yang feiyangyang = new Yang("沸羊羊", R.drawable.feiyangyang);
            yangList.add(feiyangyang);
            Yang lanyangyang = new Yang("懒羊羊", R.drawable.lanyangyang);
            yangList.add(lanyangyang);
            Yang nuanyangyang = new Yang("暖羊羊", R.drawable.nuanyangyang);
            yangList.add(nuanyangyang);
            Yang manyangyang = new Yang("慢羊羊", R.drawable.manyangyang);
            yangList.add(manyangyang);
            Yang huitailang = new Yang("灰太狼", R.drawable.huitailang);
            yangList.add(huitailang);
            Yang hongtailang = new Yang("红太狼", R.drawable.hongtailang);
            yangList.add(hongtailang);
            Yang xiaohuihui = new Yang("小灰灰", R.drawable.xiaohuihui);
            yangList.add(xiaohuihui);


        }
    }
}
