package com.example.xianling.jian;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 2016/1/25.
 */
public class Top4Activity1 extends Activity {
      List<String> stringList=new ArrayList<>();

     String[] data={"                              偏好设置","阅读字号","默认编辑器","喜欢文章后自动弹出窗口","移动网络不下载图片",
            "                              离线阅读","自动离线下载","离线设置","                                  其他",
            "黑名单设置","清除缓存","推送通知","关于我们","                           退出当前账号"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top4activity1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                Top4Activity1.this,android.R.layout.simple_list_item_1,data
        );
        stringList.add(data[0]);
        stringList.add(data[1]);
        stringList.add(data[2]);
        stringList.add(data[3]);
        stringList.add(data[4]);
        stringList.add(data[5]);
        stringList.add(data[6]);
        stringList.add(data[7]);
        stringList.add(data[8]);
        stringList.add(data[9]);
        stringList.add(data[10]);
        stringList.add(data[11]);
        stringList.add(data[12]);
        stringList.add(data[13]);
        ListView listView=(ListView) findViewById(R.id.list_view4);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(stringList.get(position).equals(data[13])){
                 AlertDialog.Builder dialog=new AlertDialog.Builder(Top4Activity1.this);
                    dialog.setMessage("你确定要退出当前账号吗");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(Top4Activity1.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
               if(stringList.get(position).equals(data[12])){
                   Intent intent=new Intent(Top4Activity1.this,Top4Activity2.class);
                   startActivity(intent);
               }
                if(stringList.get(position).equals(data[11])){
                    Intent intent=new Intent(Top4Activity1.this,TstzActivity.class);
                    startActivity(intent);
                }
                if(stringList.get(position).equals(data[9])){
                    Intent intent=new Intent(Top4Activity1.this,HmdActivity.class);
                    startActivity(intent);
                }
                if(stringList.get(position).equals(data[7])){
                    Intent intent=new Intent(Top4Activity1.this,LxszActivity.class);
                    startActivity(intent);
                }
                if(stringList.get(position).equals(data[1])){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(Top4Activity1.this);
                    String[] data={"特大","大","中","小","取消"};
                    dialog.setItems(data, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
                if(stringList.get(position).equals(data[2])){
                    AlertDialog.Builder builder=new AlertDialog.Builder(Top4Activity1.this);
                    String[] data={"富文本","Markdown","取消"};
                    builder.setItems(data, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }
        });
    }
}