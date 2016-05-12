package com.example.xianling.jian;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/1/21.
 */
public class Top4Activity extends Fragment {
   private List<Page> pageList = new ArrayList<Page>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initPages();
        View view = inflater.inflate(R.layout.top4, container, false);
        Button button=(Button) view.findViewById(R.id.button_my);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyPageActivity.class);
                startActivity(intent);
            }
        });
        ListView listView=(ListView) view.findViewById(R.id.list_view);
        PageAdapter ad=new PageAdapter(getActivity(),R.layout.page_item,pageList);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Page page = pageList.get(position);
               // Toast.makeText(getActivity(),page.getName(),Toast.LENGTH_SHORT).show();
                if(page.getName().equals("公开文章")){
                   Intent intent=new Intent(getActivity(),PublicStory.class);
                    startActivity(intent);
                }
                if(page.getName().equals("私密文章")){
                   Intent intent=new Intent(getActivity(),PrivateStory.class);
                    startActivity(intent);
                }
                if(page.getName().equals("我的收藏")){
                   Intent intent=new Intent(getActivity(),CollectActivity.class);
                    startActivity(intent);
                }
                if(page.getName().equals("喜欢的文章")){
                   Intent intent=new Intent(getActivity(),LikeActivity.class);
                    startActivity(intent);
                }
                if(page.getName().equals("通用设置")){
                    Intent intent=new Intent(getActivity(),Top4Activity1.class);
                    startActivity(intent);
                }
                if(page.getName().equals("意见反馈")){
                    Intent intent=new Intent(getActivity(),YjfkActivity.class);
                    startActivity(intent);
                }
                if(page.getName().equals("给简书评分")){
                    Intent intent=new Intent(getActivity(),CommentsActivity.class);
                    startActivity(intent);
                }

            }
        });
        return view;

    }
    private void initPages(){
        Page page1=new Page("公开文章",R.mipmap.thing1);
        pageList.add(page1);
        Page page2=new Page("私密文章",R.mipmap.thing2);
        pageList.add(page2);
        Page page3=new Page("我的收藏",R.mipmap.thing3);
        pageList.add(page3);
        Page page4=new Page("喜欢的文章",R.mipmap.thing4);
        pageList.add(page4);
        Page page5=new Page("通用设置",R.mipmap.thing5);
        pageList.add(page5);
        Page page6=new Page("分享简书App",R.mipmap.thing6);
        pageList.add(page6);
        Page page7=new Page("意见反馈",R.mipmap.thing7);
        pageList.add(page7);
        Page page8=new Page("给简书评分",R.mipmap.thing8);
        pageList.add(page8);
    }

}
