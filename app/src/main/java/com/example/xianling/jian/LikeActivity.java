package com.example.xianling.jian;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by xianling on 2016/2/11.
 */
public class LikeActivity extends Activity {
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.likeactivity);
        SharedPreferences pref = getSharedPreferences("data4", MODE_PRIVATE);
        String name1 = pref.getString("name", "");
        String id1 = pref.getString("id", "");
        textView1 = (TextView) findViewById(R.id.textViewAAAA);
        textView2 = (TextView) findViewById(R.id.textViewBBBB);
        textView1.setText(name1);
        textView2.setText(id1);
    }
}
