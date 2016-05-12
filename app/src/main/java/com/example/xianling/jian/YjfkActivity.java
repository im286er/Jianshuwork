package com.example.xianling.jian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xianling on 2016/1/26.
 */
public class YjfkActivity extends Activity {
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.yjfk);
        Bmob.initialize(YjfkActivity.this, "057b2e5f736d9a43e528f089b560189f");
        editText1=(EditText) findViewById(R.id.message);
        editText2=(EditText) findViewById(R.id.edittext_liu);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person2 person=new Person2();
                person.setContext(editText1.getContext().toString());
                person.setTel(editText1.getText().toString());
                person.save(YjfkActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(YjfkActivity.this,"意见反馈成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
            }
        });
    }
}
