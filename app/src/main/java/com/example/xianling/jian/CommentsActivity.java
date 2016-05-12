package com.example.xianling.jian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xianling on 2016/2/22.
 */
public class CommentsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commentsactivity);
        Bmob.initialize(CommentsActivity.this, "057b2e5f736d9a43e528f089b560189f");
        Button button=(Button) findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.popwindow, null);
                final PopupWindow popupWindow = new PopupWindow(view,
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.edit_text));
                //popupWindow.getBackground().setAlpha(100);//设置透明度
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setAnimationStyle(android.R.style.Animation_Translucent);
                popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                //显示
                popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                Button button1 = (Button) view.findViewById(R.id.button_baocun);
                final EditText editText = (EditText) view.findViewById(R.id.editText_window);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sc = editText.getText().toString();
                        Person3 person3 = new Person3();
                        person3.setContect(sc);
                        person3.save(CommentsActivity.this, new SaveListener() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(CommentsActivity.this, "成功发布评论", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(int i, String s) {
                                Toast.makeText(CommentsActivity.this, "发布评论失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                        popupWindow.dismiss();
                    }
                });
            }
        });
        BmobQuery<Person3> query=new BmobQuery<>();
        query.findObjects(CommentsActivity.this, new FindListener<Person3>() {
            @Override
            public void onSuccess(List<Person3> list) {
                PingLunAdapter adapter=new PingLunAdapter(CommentsActivity.this,list);
                ListView listView=(ListView) findViewById(R.id.listview_pinglun);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
        TextView textView_shua=(TextView)findViewById(R.id.textview_shuaxin);
        textView_shua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CommentsActivity.this,CommentsActivity.class);
                startActivity(intent);
            }
        });
    }
}
