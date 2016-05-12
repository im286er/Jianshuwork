package com.example.xianling.jian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo info=cm.getActiveNetworkInfo();
        if(info!=null){
            String name=info.getTypeName();
            Toast.makeText(context, "你已连接到" + name, Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "无网络连接", Toast.LENGTH_SHORT).show();
        }
    }
}
