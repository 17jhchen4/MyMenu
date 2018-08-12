package com.example.mymenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Many4Activity extends AppCompatActivity
{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Init();//初始化
        Intent intent = new Intent(getApplicationContext(),ManyActivity_Login.class);
        startActivity(intent);
        finish();
    }

    public void Init()
    {
        button = (Button) findViewById(R.id.button_zhuxiao);
    }
}
