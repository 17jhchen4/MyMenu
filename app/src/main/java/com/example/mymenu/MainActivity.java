package com.example.mymenu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    OkHttpClient okHttpClient = new OkHttpClient();
    //okHttpClient使用全局变量
    private String number = "1";
    private String url = "http://apis.juhe.cn/cook/index?key=fe54bbf9eeb97a42646d3a114b1725b1&cid="+ number;
    private String str;
//    private String url_2 = "http://apis.juhe.cn/cook/query?key=fe54bbf9eeb97a42646d3a114b1725b1&menu=" + str + "&rn=&pn=&";
    private TextView textView;
    private Button button,button_1,button_2,button_3,button_4;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyAdapter myAdapter;
    private Request request;
    private Call call;
    private List<Client_1> listItems;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity);

        Init();//初始化

        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Request request, IOException e)
            {
                Log.e("TAG",e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException
            {
                final String json = response.body().string();
                Client_All client_all = GsonUtil.parseJsonWithGson(json,Client_All.class);
                for (int i = 0; i< client_all.getResult().getData().size(); i++)
                {
                    Client_1 client_1= new Client_1();
                    client_1.setTitle(client_all.getResult().getData().get(i).getTitle());
                    client_1.setTags(client_all.getResult().getData().get(i).getTags().substring(0,18) + "……");
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
//                        textView.setText(client_all.getResult().getData().get(1).getAlbums());
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
                        });//为RecyclerView设置点击事件


                        recyclerView.setNestedScrollingEnabled(false);
                        recyclerView.setAdapter(myAdapter);
                    }
                });
            }
        });//发送网络请求


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                str = String.valueOf(textView.getText());
                Log.i("TAG",str);
//                request_2 = new Request.Builder().url(url_2).build();
//                call = okHttpClient.newCall(request_2);
//                call.enqueue(new Callback()
//                {
//                    @Override
//                    public void onFailure(Request request, IOException e)
//                    {
//                        Log.e("TAG",e.getMessage());
//                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(Response response) throws IOException
//                    {
//                        String json = response.body().string();
//                        Client_All client_all = GsonUtil.parseJsonWithGson(json,Client_All.class);
//                        for (int i = 0; i< client_all.getResult().getData().size(); i++)
//                        {
//                            Client_1 client_1= new Client_1();
//                            client_1.setTitle(client_all.getResult().getData().get(i).getTitle());
//                            client_1.setTags(client_all.getResult().getData().get(i).getTags().substring(0,18) + "……");
//                            client_1.setAlbums(client_all.getResult().getData().get(i).getAlbums());
//                            client_1.setId(client_all.getResult().getData().get(i).getId());
//                            client_1.setIngredients(client_all.getResult().getData().get(i).getIngredients());
//                            client_1.setBurden(client_all.getResult().getData().get(i).getBurden());
//                            client_1.setImtro(client_all.getResult().getData().get(i).getImtro());
//                            client_1.setSteps(client_all.getResult().getData().get(i).getSteps());
//                            listItems_2.add(client_1);
//                        }
//
//                    }
//                });
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("Search_res",str);
                startActivity(intent);
            }
        });//设置搜索按钮的点击事件


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            Random random = new Random();

            @Override
            public void onRefresh()
            {
                swipeRefreshLayout.setRefreshing(true);

                number = String.valueOf(random.nextInt(100)+1);
                url = "http://apis.juhe.cn/cook/index?key=fe54bbf9eeb97a42646d3a114b1725b1&cid="+ number;
                Request request = new Request.Builder().url(url).build();
                final Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback()
                {
                    @Override
                    public void onFailure(Request request, IOException e)
                    {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onResponse(Response response) throws IOException
                    {
                        final String json_2 = response.body().string();
                        Client_All client_all_2 = GsonUtil.parseJsonWithGson(json_2,Client_All.class);
                        listItems.clear();
                        Log.i("TAG",client_all_2.getresultcode());
                        if (!client_all_2.getresultcode().equals("200"))
                        {
                            Toast.makeText(MainActivity.this,"刷新失败，请重试",Toast.LENGTH_SHORT).show();
                            call.cancel();
                        }
                        else
                        {
                            for (int i = 0; i< client_all_2.getResult().getData().size(); i++)
                            {
                                Client_1 client_1= new Client_1();
                                client_1.setTitle(client_all_2.getResult().getData().get(i).getTitle());

                                if(client_all_2.getResult().getData().get(i).getTags().length()>=17)
                                {
                                    client_1.setTags(client_all_2.getResult().getData().get(i).getTags().substring(0,17) + "……");
                                }
                                else
                                {
                                    client_1.setTags(client_all_2.getResult().getData().get(i).getTags()
                                            .substring(0,client_all_2.getResult().getData().get(i).getTags().length()) + "……");
                                }
//                            client_1.setTags(client_all_2.getResult().getData().get(i).getTags().substring(0,7)+"……");
                                client_1.setAlbums(client_all_2.getResult().getData().get(i).getAlbums());
                                client_1.setId(client_all_2.getResult().getData().get(i).getId());
                                client_1.setIngredients(client_all_2.getResult().getData().get(i).getIngredients());
                                client_1.setBurden(client_all_2.getResult().getData().get(i).getBurden());
                                client_1.setImtro(client_all_2.getResult().getData().get(i).getImtro());
                                client_1.setSteps(client_all_2.getResult().getData().get(i).getSteps());
                                listItems.add(client_1);
                            }
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
//                        textView.setText(client_all.getResult().getData().get(1).getAlbums());
//                                myAdapter.setData(listItems);
                                    myAdapter.notifyDataSetChanged();
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


//                                recyclerView.setNestedScrollingEnabled(false);
//                                recyclerView.setAdapter(myAdapter);
                                }
                            });
                        }

                    }
                });

                swipeRefreshLayout.setRefreshing(false);

            }
        });//实现下拉刷新

        button_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //跳转到activity_4中
                Intent intent = new Intent(getApplicationContext(),Many4Activity.class);
                startActivity(intent);
            }
        });//实现“菜单按钮”


    }

    public void Init()
    {
        textView = (TextView) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button_sousuo);
        button_1 = (Button) findViewById(R.id.button_caipu);
        button_2 = (Button) findViewById(R.id.button_shicai);
        button_3 = (Button) findViewById(R.id.button_zhuanti);
        button_4 = (Button) findViewById(R.id.button_caidan);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        myAdapter = new MyAdapter(this);
        request = new Request.Builder().url(url).build();
        call = okHttpClient.newCall(request);
        listItems = new ArrayList<Client_1>();
    }
}
