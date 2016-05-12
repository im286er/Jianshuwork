package com.example.xianling.jian;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xianling on 2016/2/4.
 */
public class Top5Activity extends Activity {
    private EditText editText1,editText2,editText3;
    private String name;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top5);
        Bmob.initialize(Top5Activity.this, "057b2e5f736d9a43e528f089b560189f");
        editText1=(EditText) findViewById(R.id.edittext1);
        editText2=(EditText) findViewById(R.id.edittext2);
        editText3=(EditText) findViewById(R.id.editText3);
        Button button=(Button) findViewById(R.id.button10);
        Button button1=(Button) findViewById(R.id.button11);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Top5Activity.this);
                String[] data={"发布于公开文章","发布于私密文章","发布于我的收藏","发布于喜欢的文章"};
                builder.setTitle("          选择发布位置");
                builder.setItems(data, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                SharedPreferences.Editor editor1=getSharedPreferences("data",MODE_PRIVATE).edit();
                                name=editText1.getText().toString();
                                id=editText2.getText().toString();
                                editor1.putString("name", name);
                                editor1.putString("id", id);
                                editor1.commit();
                                Person person=new Person();
                                person.setAuthor(editText3.getText().toString());
                                person.setTitle(editText1.getText().toString());
                                person.setContent(editText2.getText().toString());
                                person.save(Top5Activity.this, new SaveListener() {
                                    @Override
                                    public void onSuccess() {
                                        Toast.makeText(Top5Activity.this,"你已发布公开文章",Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(int i, String s) {
                                        Toast.makeText(Top5Activity.this,"你发布公开文章失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                            case 1:
                                Toast.makeText(Top5Activity.this,"你已发布了私密文章",Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor2=getSharedPreferences("data2",MODE_PRIVATE).edit();
                                name=editText1.getText().toString();
                                id=editText2.getText().toString();
                                editor2.putString("name",name);
                                editor2.putString("id",id);
                                editor2.commit();
                                break;
                            case 2:
                                Toast.makeText(Top5Activity.this,"你已发布了收藏文章",Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor3=getSharedPreferences("data3",MODE_PRIVATE).edit();
                                name=editText1.getText().toString();
                                id=editText2.getText().toString();
                                editor3.putString("name",name);
                                editor3.putString("id", id);
                                editor3.commit();
                                break;
                            case  3:
                                Toast.makeText(Top5Activity.this,"你已发布了喜欢的文章",Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor4=getSharedPreferences("data4",MODE_PRIVATE).edit();
                                name=editText1.getText().toString();
                                id=editText2.getText().toString();
                                editor4.putString("name",name);
                                editor4.putString("id", id);
                                editor4.commit();
                                break;
                        }
                    }
                });
                builder.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Top5Activity.this);
                dialog.setTitle("是否要退出当前编辑");
                dialog.setMessage("如果你选择继续，可能会丢失当前编辑内容");
                dialog.setCancelable(false);
                dialog.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Top5Activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });


    }
}
