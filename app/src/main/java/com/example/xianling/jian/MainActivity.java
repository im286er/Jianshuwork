package com.example.xianling.jian;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button4=(Button) findViewById(R.id.button4);
        Button button3=(Button) findViewById(R.id.button3);
        Button button6=(Button) findViewById(R.id.button6);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        if(bundle.getString("jianshu").equals("1")){
            Top1Activity top=new Top1Activity();
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.top,top);
            transaction.commit();
        }
        button6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Top5Activity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View v) {
                Top3Activity top=new Top3Activity();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();//开启一个事物
                transaction.replace(R.id.top,top);
                transaction.commit();
            }
        }));
        button4.setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View v) {
                Top4Activity top=new Top4Activity();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.top,top);
                transaction.commit();
            }
        }));
        button1.setOnClickListener((new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Top1Activity top=new Top1Activity();
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction transaction=fragmentManager.beginTransaction();
                        transaction.replace(R.id.top,top);
                        transaction.commit();
            }
        }));
        button2.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Top2Activity top=new Top2Activity();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.top,top);
                transaction.commit();
        }
        });
    }


}
