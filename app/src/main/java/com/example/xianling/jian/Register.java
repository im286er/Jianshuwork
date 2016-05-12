package com.example.xianling.jian;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xianling on 2016/2/7.
 */
public class Register extends Activity {
    EditText editText1;
    EditText editText2;
    SQLiteOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        helper = new MyDatabaseHelper(this);
        helper.getWritableDatabase();
        editText1=(EditText) findViewById(R.id.account);
        editText2=(EditText) findViewById(R.id.password);
        Button button1=(Button) findViewById(R.id.tuichu);
        Button button2=(Button) findViewById(R.id.register2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(Register.this, "还未填写注册信息", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        SQLiteDatabase db = helper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("account", editText1.getText().toString());
                        values.put("password", editText2.getText().toString());
                        db.insert("jianshu", null, values);
                        Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                    } catch (SQLiteException e) {
                        Toast.makeText(Register.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
