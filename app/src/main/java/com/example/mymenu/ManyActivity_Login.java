package com.example.mymenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class ManyActivity_Login extends AppCompatActivity
{

    private static User user;
    private EditText editText_name,editText_paword;
    private Button button_login,button_register,button_text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Init();//初始化




        button_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user_name = String.valueOf(editText_name.getText());
                String user_password = String.valueOf(editText_paword.getText());
                login(ManyActivity_Login.this,user_name,user_password);
            }
        });//设置登陆按钮的点击事件

        button_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity_register.class);
                startActivity(intent);
            }
        });//设置注册按钮的点击事件

        button_text.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void Init()
    {
        Bmob.initialize(this,"1a05f998595da6ce44aa0520dd079ff5");
        //初始化Bmob
        editText_name = (EditText) findViewById(R.id.edit_name);
        editText_paword = (EditText) findViewById(R.id.edit_pasword);
        button_login = (Button) findViewById(R.id.button_login);
        button_register = (Button) findViewById(R.id.button_register);
        button_text = (Button) findViewById(R.id.button_text);
    }

    public static void login(final Activity activity, String username, String password)
    {
//        DialogUtils.showLoadingDialog(activity, "正在登陆中", true);
        DialogUtils.showToast(activity,"正在登陆中");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.login(activity, new SaveListener()
        {
            @Override
            public void onSuccess()
            {
                //跳转主页面
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }

            @Override
            public void onFailure(int code, String msg)
            {
                if (code == 9016)
                {
//                    DialogUtils.successLoadingDialog("请连接网络");
                    DialogUtils.showToast(activity,"请连接网络");
                } else
                    {
//                    DialogUtils.errorLoadingDialog("用户名或密码错误");
                    DialogUtils.showToast(activity,"用户名或密码错误");
                }
            }
        });
    }//请求登陆


    public static User getUser(Context context)
    {
        user = BmobUser.getCurrentUser(context, User.class);
        return user;
    }//获取当前用户

    public static void loginOut(Context context)

    {
        BmobUser.logOut(context);
    }
    //退出当前用户(用户注销请求)

}
