package com.example.llw.demo_handler_get_native_picturic;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button btn;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun();
            }
        });
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Integer is = (Integer) msg.obj;
                imageView.setImageResource(is);
            }
        };
    }

    public void  fun(){
        new Thread(){
            @Override
            public void run() {
                Message message = new Message();
                message.obj = R.mipmap.a1;
                handler.sendMessage(message);
            }
        }.start();
    }

}
