package com.example.mymenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder_2 extends RecyclerView.ViewHolder
{
    TextView textView1,textView2;

    public MyViewHolder_2(View view)
    {
        super(view);

        textView1 = (TextView) view.findViewById(R.id.textView_material);
        textView2 = (TextView) view.findViewById(R.id.textView_dosage);
    }
}
