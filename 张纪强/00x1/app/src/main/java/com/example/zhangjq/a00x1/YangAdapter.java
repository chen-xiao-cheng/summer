package com.example.zhangjq.a00x1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class YangAdapter extends RecyclerView.Adapter<YangAdapter.ViewHolder> {
    private List<Yang> mYangList;


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView yangImage;
        TextView yangName;

        public  ViewHolder(View view){
            super(view);
            yangImage = (ImageView)view.findViewById(R.id.yang_image);
            yangName = (TextView)view.findViewById(R.id.yang_name);
        }
    }

        public YangAdapter(List<Yang> yangList){
            mYangList = yangList;
        }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yang ,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int positon) {
     Yang yang = mYangList.get(positon);
     holder.yangImage.setImageResource(yang.getImageId());
     holder.yangName.setText(yang.getName());

    }

    @Override
    public int getItemCount() {
        return mYangList.size();
    }

    }


