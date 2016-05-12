package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xianling on 2016/3/1.
 */
public class BianjiActivity extends Activity{
    private static final int RESULT_CODE_1 = 0x1;
    private TextView textView,textView1,textView2;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bianjiactivity);
        pref= PreferenceManager.getDefaultSharedPreferences(BianjiActivity.this);
        textView=(TextView) findViewById(R.id.miaoshu);
        textView2=(TextView) findViewById(R.id.quxiao);
        String msg=pref.getString("number", "");
        textView.setText(msg);
        textView1=(TextView) findViewById(R.id.wancheng);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=textView.getText().toString();
                editor=pref.edit();
                editor=editor.putString("number", number);
                editor.commit();
                Toast.makeText(BianjiActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(BianjiActivity.this,MyPageActivity.class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BianjiActivity.this,MiaoshiActivity.class);
                startActivityForResult(intent, RESULT_CODE_1);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BianjiActivity.this,MyPageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_CODE_1 && resultCode==RESULT_OK){
            String info=data.getStringExtra("data");
            textView.setText(info);
        }
    }
}
