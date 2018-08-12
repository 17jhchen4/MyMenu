package com.example.mymenu;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder_3 extends RecyclerView.ViewHolder
{
     ImageView imageView;
     TextView textView;

    public MyViewHolder_3(View view)
    {
        super(view);

        imageView = (ImageView) view.findViewById(R.id.imageView_img);
        textView = (TextView) view.findViewById(R.id.textView_step);

    }
}
