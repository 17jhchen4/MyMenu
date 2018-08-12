package com.example.mymenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView textView1,textView2;
    ImageView imageView;

    public MyViewHolder(View view)
    {
        super(view);

        textView1 = (TextView) view.findViewById(R.id.textView_title);
        textView2 = (TextView) view.findViewById(R.id.textView_tags);
        imageView = (ImageView) view.findViewById(R.id.imageView);
    }

    public ImageView getimageView()
    {
        return imageView;
    }
}
