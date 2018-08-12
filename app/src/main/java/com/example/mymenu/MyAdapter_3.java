package com.example.mymenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter_3 extends RecyclerView.Adapter<MyViewHolder_3>
{

    private List<String> list;
    private LayoutInflater inflater;


    public MyAdapter_3(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder_3 onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder_3 myViewHolder_3 = new MyViewHolder_3(inflater.inflate(R.layout.recycle_item_3,parent,false));
        return myViewHolder_3;
    }

    @Override
    public void onBindViewHolder(MyViewHolder_3 holder, int position)
    {
        Glide.with(holder.imageView.getContext()).load(list.get(position*2))
                .placeholder(R.mipmap.ic_launcher).into(holder.imageView);
        holder.textView.setText(list.get(position*2+1));

    }

    @Override
    public int getItemCount()
    {
        return list.size()/2;
    }

    public void setData(List<String> list)
    {
        this.list = list;
    }
}
