package com.example.xianling.jian;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/1/27.
 */
public class TstzActivity extends Activity {
    private String[]data={"评论","请求","喜欢","关注","其他","简信","精选"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tstzactivity);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
             TstzActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView) findViewById(R.id.listView6);
        listView.setAdapter(adapter);
    }

}
