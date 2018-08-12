package com.example.mymenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter_2 extends RecyclerView.Adapter<MyViewHolder_2>
{

    private List<String> list;
    private LayoutInflater inflater;

    public MyAdapter_2(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder_2 onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder_2 myViewHolder_2 =
                new MyViewHolder_2(inflater.inflate(R.layout.recycle_item_2,parent,false));
        return myViewHolder_2;
    }

    @Override
    public void onBindViewHolder(MyViewHolder_2 holder, int position)
    {
        holder.textView1.setText(list.get(position*2));
        holder.textView2.setText(list.get(position*2+1));
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
