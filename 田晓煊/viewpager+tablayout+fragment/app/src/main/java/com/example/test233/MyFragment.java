package com.example.test233;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {
    TextView textView;
   String msg;
    public static MyFragment getInstance(String msg){

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle i) {
        if (getArguments() != null)
            msg = getArguments().getString("msg");
            View view = inflater.inflate(R.layout.fragment, container, false);
            return view;
    }

    public void onViewCreated(View view,Bundle bundle)
    {
        textView = view.findViewById(R.id.tv);
        textView.setText(msg);
    }
}






