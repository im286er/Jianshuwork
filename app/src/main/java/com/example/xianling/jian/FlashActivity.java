package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

/**
 * Created by xianling on 2016/2/18.
 */
public class FlashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashactivity);
        Button button=(Button) findViewById(R.id.button_flash);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
});
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
              start();
            }
        },3000);
    }
    public void start(){
        Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    private final MyHandle handle=new MyHandle(this);
            private static class MyHandle extends Handler{
                WeakReference<FlashActivity> weakReference;
                public MyHandle(FlashActivity activity){
            weakReference=new WeakReference<FlashActivity>(activity);
        }
        public void HandleMessage(Message msg){
            super.handleMessage(msg);
        }
    }
}
