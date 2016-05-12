package com.example.xianling.jian;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by xianling on 2016/1/27.
 */
public class LxszActivity extends Activity {
    String[] data={"热门文章","我的关注","我的收藏"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lxszactivity);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                LxszActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView) findViewById(R.id.listView7);
        listView.setAdapter(adapter);
    }
}
