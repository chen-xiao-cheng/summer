package com.example.test233;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test233.bean.HttpBean;
import com.example.test233.bean.ZhBean;
import com.example.test233.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpBean httpBean = new HttpBean("https://news-at.zhihu.com/api/4/news/latest", "GET", null);
                HttpUtil.GetHttpString(httpBean, new CallBcak() {
                    @Override
                    public void Finish(final String s) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(s);
                            }
                        });
                    }
                });

            }
        }).start();

    }


    public void getjson(String s)//此方法为json解析

    {
        try{
            JSONObject jsonObject = new JSONObject(s);
            int date = jsonObject.getInt("date");
            String stories = jsonObject.getString("stories");
            String top_stories = jsonObject.getString("top_stories");
            JSONArray jsonArray = new JSONArray(stories);
            for(int i = 0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                ZhBean zhBean = new ZhBean();
                zhBean.setGa_prefix(jsonObject1.getString("ga_prefix"));
                zhBean.setId(jsonObject1.getInt("id"));
                zhBean.setTitle(jsonObject1.getString("titels"));
                zhBean.setType(jsonObject1.getInt("type"));
                JSONArray jsonArray1 = jsonObject1.getJSONArray("images");
                zhBean.setImages(jsonArray1.getString(0));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
