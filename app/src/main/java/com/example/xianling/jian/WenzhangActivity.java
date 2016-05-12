package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xianling on 2016/3/3.
 */
public class WenzhangActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TextView textView1,textView2,textView3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wenzhangactivity);
        textView1=(TextView) findViewById(R.id.textView_biaoti);
        textView2=(TextView) findViewById(R.id.textView_zuozhe);
        textView3=(TextView) findViewById(R.id.textView_neirong);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        final String info=bundle.getString("s");
        BmobQuery<Person> query=new BmobQuery<>();
        query.findObjects(WenzhangActivity.this, new FindListener<Person>() {
            @Override
            public void onSuccess(List<Person> list) {
                for(Person person:list){
                    if(person.getTitle().equals(info)){
                        textView1.setText(person.getTitle());
                        textView2.setText(person.getAuthor());
                        textView3.setText(person.getContent());
                    }
                }
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
