package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by xianling on 2016/1/26.
 */
public class HyActivity extends Activity{
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.hyactivity);
        Button button=(Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(HyActivity.this,Top4Activity2.class);
                startActivity(intent);
            }
        });
    }
}
