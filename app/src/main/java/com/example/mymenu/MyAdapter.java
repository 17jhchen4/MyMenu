package com.example.mymenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{

    private List<Client_1>data;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public MyAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder myViewHolder = new MyViewHolder(inflater.inflate(R.layout.recycle_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.textView1.setText(data.get(position).getTitle());
        holder.textView2.setText(data.get(position).getTags());
        Glide.with(holder.imageView.getContext()).load(data.get(position).getAlbums()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);

        if (onRecyclerViewItemClickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    onRecyclerViewItemClickListener.onItemClick(v,position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    onRecyclerViewItemClickListener.onItemLongClick(v,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public void setData(List<Client_1> pDatas)
    {
        data = pDatas;
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener)
    {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
