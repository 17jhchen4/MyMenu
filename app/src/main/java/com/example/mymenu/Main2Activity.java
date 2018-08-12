package com.example.mymenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
{
    private ImageView imageView;
    private TextView textView1,textView2;
    private Client_1 client_1;
    private Intent intent;
    private String[] s1,s2;
    private List<String> list_2,list_3;
    private MyAdapter_2 myAdapter_2;
    private MyAdapter_3 myAdapter_3;
    private RecyclerView recyclerView_2,recyclerView_3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Init();//初始化
        Glide.with(this).load(client_1.getAlbums())
                .placeholder(R.mipmap.ic_launcher).into(imageView);
        textView1.setText(client_1.getTitle());
        textView2.setText(client_1.getImtro());

        InitAdapter();
        recyclerView_2.setAdapter(myAdapter_2);
        recyclerView_3.setAdapter(myAdapter_3);


    }

    public void Init()
    {
        intent = getIntent();
        client_1 = (Client_1) intent.getSerializableExtra("DATA");
        myAdapter_2 = new MyAdapter_2(this);
        myAdapter_3 = new MyAdapter_3(this);
        recyclerView_2 = (RecyclerView) findViewById(R.id.recycle_view_2);
        recyclerView_2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_2.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView_2.setNestedScrollingEnabled(false);
        recyclerView_3 = (RecyclerView) findViewById(R.id.recycle_view_3);
        recyclerView_3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_3.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView_3.setNestedScrollingEnabled(false);



        list_2 = new ArrayList<>();
        list_3 = new ArrayList<>();
        imageView = (ImageView) findViewById(R.id.imageView2);
        textView1 = (TextView) findViewById(R.id.textView_Title);
        textView2 = (TextView) findViewById(R.id.textView_imtro);
    }

    public void InitAdapter()
    {
        s1 = client_1.getIngredients().split("\\p{Punct}");
        s2 = client_1.getBurden().split("\\p{Punct}");

        for (int i=0;i<s1.length;i++)
        {
            list_2.add(s1[i]);
        }

        for (int i=0;i<s2.length;i++)
        {
            list_2.add(s2[i]);
        }

        myAdapter_2.setData(list_2);

        for (int i =0; i<client_1.getSteps().size();i++)
        {
            list_3.add(client_1.getSteps().get(i).getImg());
            list_3.add(client_1.getSteps().get(i).getStep());
        }

        myAdapter_3.setData(list_3);

    }
}


