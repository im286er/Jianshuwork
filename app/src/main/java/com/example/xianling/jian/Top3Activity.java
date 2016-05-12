package com.example.xianling.jian;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/1/22.
 */
public class Top3Activity extends Fragment {
  private List<Thing> thingList = new ArrayList<Thing>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initThings();
        View view = inflater.inflate(R.layout.top3, container, false);
        ListView listView1 = (ListView) view.findViewById(R.id.list_view);
        ThingAdapter ad1=new ThingAdapter(getActivity(),R.layout.thing_item,thingList);
        listView1.setAdapter(ad1);
        Button button=(Button) view.findViewById(R.id.button20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TstzActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
private void initThings(){
        thingList.add(new Thing("简友动态",R.mipmap.thing1));
        Thing thing2=new Thing("评论",R.mipmap.thing2);
        thingList.add(thing2);
        Thing thing3=new Thing("简信",R.mipmap.thing3);
        thingList.add(thing3);
        Thing thing4=new Thing("请求",R.mipmap.thing4);
        thingList.add(thing4);
        Thing thing5=new Thing("喜欢",R.mipmap.thing5);
        thingList.add(thing5);
        Thing thing6=new Thing("关注",R.mipmap.thing6);
        thingList.add(thing6);
        Thing thing7=new Thing("其他提醒",R.mipmap.thing7);
        thingList.add(thing7);
    }
}
