package com.example.mymenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity_register extends AppCompatActivity
{
    private EditText editText,editText_2,editText_3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Init();//初始化
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = String.valueOf(editText.getText());
                String password = String.valueOf(editText_2.getText());
                String password_again = String.valueOf(editText_3.getText());
                if (password.equals(password_again))
                {
                    register(MainActivity_register.this,name,password);
                }
                else
                {
                    Toast.makeText(v.getContext(),"",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Init()
    {
//        Bmob.initialize(this,"1a05f998595da6ce44aa0520dd079ff5");
        //初始化Bmob
        editText = (EditText) findViewById(R.id.register_name);
        editText_2 = (EditText) findViewById(R.id.register_password);
        editText_3 = (EditText) findViewById(R.id.register_password2);
        button = (Button) findViewById(R.id.button_sure);
    }

    public static void register(final Activity activity, String username, String password)
    {
//        DialogUtils.showLoadingDialog(activity, "正在注册", true);
        DialogUtils.showToast(activity,"正在注册");
        BmobUser u = new BmobUser();
        u.setUsername(username);
        u.setPassword(password);
        u.signUp(activity, new SaveListener()
        {
            @Override
            public void onSuccess()
            {
                //注册成功
//                DialogUtils.successLoadingDialog("注册成功");
                DialogUtils.showToast(activity,"注册成功");
//                Intent intent = new Intent(activity, MainActivity.class);
//                activity.startActivity(intent);
                activity.finish();
            }

            @Override
            public void onFailure(int code, String msg)
            {
                if (code == 9016)
                {
//                    DialogUtils.errorLoadingDialog("请连接网络");
                    DialogUtils.showToast(activity,"请连接网络");
                } else if (code == 202)
                {
//                    DialogUtils.errorLoadingDialog("用户名已存在");
                    DialogUtils.showToast(activity,"用户名已存在,请重试");
                } else
                {
//                    DialogUtils.errorLoadingDialog("注册失败");
                    DialogUtils.showToast(activity,"注册失败,请重试");
                }
            }
        });
    }//注册用户
}

