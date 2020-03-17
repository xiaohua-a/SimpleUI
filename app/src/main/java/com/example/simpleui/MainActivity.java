package com.example.simpleui;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.app.Activity;
import android.graphics.drawable.Drawable;
public class MainActivity extends Activity {
    //初始化变量,帧布局
    FrameLayout	frame	=	null;
    //自定义一个用于定时更新 UI 界面的 handler 类对象
    Handler	handler	=	new Handler() {
        int i	=	0;
        @Override
        public void handleMessage(Message	msg)	{
            //判断信息是否为本应用发出的
            if(msg.what	==	0x123)
            {
                i++;
                move(i	%	8 );
            }
            super.handleMessage(msg);
        }
    };
    //定义走路时切换图片的方法
    void move(int i)
    {
        Drawable	a	=	getResources().getDrawable(R.drawable.ha);
        Drawable	b	=	getResources().getDrawable(R.drawable.xiao);
        Drawable	c	=	getResources().getDrawable(R.drawable.ha);
        Drawable	d	=	getResources().getDrawable(R.drawable.xiao);
        Drawable	e	=	getResources().getDrawable(R.drawable.ha);
        Drawable	f	=	getResources().getDrawable(R.drawable.xiao);
        Drawable	g	=	getResources().getDrawable(R.drawable.ha);
        Drawable	h	=	getResources().getDrawable(R.drawable.xiao);
        //通过 setForeground 来设置前景图像
        switch(i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nine);
        frame	=	(FrameLayout)	findViewById(R.id.myframe);
        //定义一个定时器对象,定时发送信息给 handler
        new Timer().schedule(new TimerTask()	{
            @Override
            public void run()	{
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        },	0,170);
    }
}