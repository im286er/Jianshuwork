package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by xianling on 2016/3/1.
 */
public class MiaoshiActivity extends Activity{
    EditText editText;
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.miaoshuactivity);
        editText=(EditText) findViewById(R.id.editext_miaoshu);
        Button button=(Button) findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("data",data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
