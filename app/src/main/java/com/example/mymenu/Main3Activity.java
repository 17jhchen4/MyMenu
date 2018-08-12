package com.example.mymenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity
{
    OkHttpClient okHttpClient = new OkHttpClient();
    private String name;
    private Intent intent;
    private String url;
    private Request request;
    private Call call;
    private List<Client_1> listItems;
    private TextView textView;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Init();
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Request request, IOException e)
            {
                Log.e("TAG",e.getMessage());
//                Toast.makeText(Main3Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//
            }

            @Override
            public void onResponse(Response response) throws IOException
            {
                String json = response.body().string();
                Client_All client_all = GsonUtil.parseJsonWithGson(json,Client_All.class);

                if (client_all.getReason().equals("Success"))
                {
                    for (int i = 0; i< client_all.getResult().getData().size(); i++)
                    {
                        Client_1 client_1= new Client_1();
                        client_1.setTitle(client_all.getResult().getData().get(i).getTitle());
                        client_1.setTags(client_all.getResult().getData().get(i).getTags().substring(0,8) + "……");
                        client_1.setAlbums(client_all.getResult().getData().get(i).getAlbums());
                        client_1.setId(client_all.getResult().getData().get(i).getId());
                        client_1.setIngredients(client_all.getResult().getData().get(i).getIngredients());
                        client_1.setBurden(client_all.getResult().getData().get(i).getBurden());
                        client_1.setImtro(client_all.getResult().getData().get(i).getImtro());
                        client_1.setSteps(client_all.getResult().getData().get(i).getSteps());
                        listItems.add(client_1);
                    }

                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            textView.setText("已找到 " + listItems.size() + " 条结果：");

                            myAdapter.setData(listItems);

                            myAdapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener()
                            {
                                @Override
                                public void onItemClick(View view, int position)
                                {
                                    Log.i("MainActivity", "short" + position);
                                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                                    intent.putExtra("DATA",listItems.get(position));
                                    startActivity(intent);
                                }

                                @Override
                                public void onItemLongClick(View view, int position)
                                {
                                    Log.i("MainActivity", "long" + position);
                                }
                            });
                            //为RecyclerView设置点击事件

                            recyclerView.setNestedScrollingEnabled(false);
                            recyclerView.setAdapter(myAdapter);

                        }
                    });
                }
                else
                {
                    runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        textView.setText("抱歉，没有找到与" + name +"相关的内容！");
                    }
                });
                }

            }
        });

    }

    public void Init()
    {
        textView = (TextView) findViewById(R.id.textView_search_mes);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_View_4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        myAdapter = new MyAdapter(this);
        intent = getIntent();
        name = (String) intent.getSerializableExtra("Search_res");
        url = "http://apis.juhe.cn/cook/query?key=fe54bbf9eeb97a42646d3a114b1725b1&menu=" + name + "&rn=&pn=&";
        request = new Request.Builder().url(url).build();
        call = okHttpClient.newCall(request);
        listItems = new ArrayList<Client_1>();
    }
}
