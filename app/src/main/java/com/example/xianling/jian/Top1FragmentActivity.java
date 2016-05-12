package com.example.xianling.jian;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xianling on 2016/2/25.
 */
public class Top1FragmentActivity extends Fragment {
    ViewPager pager;
    PageIndicator indicator;
    private static final int A =1 ;
    private ListView listView;
    private List<Fragment> fragmentList = new ArrayList<>();
    private ScheduledExecutorService scheduledExecutorService;
    private int currentItem;
    private int imageIds[];
    public class PageAdapter extends FragmentPagerAdapter {
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
        @Override
        public void onStart() {
            super.onStart();

            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

                  //每隔3秒钟切换一张图片
            scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),3, 3, TimeUnit.SECONDS);


    }


        private class ViewPagerTask implements Runnable {

            @Override
            public void run() {

                Message message=new Message();
                message.what=A;
                handler.sendMessage(message);
            }

        }
        private Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case A:
                        //currentItem当前页面
                        currentItem=(currentItem+1) % imageIds.length;
                        pager.setCurrentItem(currentItem);
                }
            }

        };

            @Override
              public void onStop() {
                super.onStop();
             }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.top1fragment1, container, false);
        imageIds=new int[]{
                R.mipmap.guanzhu11,
                R.mipmap.lizhi33,
                R.mipmap.lizhi11,
                R.mipmap.lizhi22
        };
         BmobQuery<Person> query=new BmobQuery<>();
         query.findObjects(getActivity(), new FindListener<Person>() {
             @Override
             public void onSuccess(final List<Person> list) {
                 PersonAdapter adapter=new PersonAdapter(getActivity(),list);
                 listView=(ListView) view.findViewById(R.id.listView_person);
                 listView.setAdapter(adapter);
                 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         Person person=list.get(position);
                         String s=person.getTitle();
                         Intent intent=new Intent(getActivity(),WenzhangActivity.class);
                         Bundle bundle=new Bundle();
                         bundle.putString("s",s);
                         intent.putExtra("bundle",bundle);
                         startActivity(intent);
                     }
                 });
             }

             @Override
             public void onError(int i, String s) {

             }
         });
         init();
         pager=(ViewPager) view.findViewById(R.id.pager1);
         indicator=(PageIndicator) view.findViewById(R.id.indicator1);
         pager.setAdapter(new PageAdapter(getChildFragmentManager()));
         indicator.setViewPager(pager);
         return view;
    }
    private void init(){
        fragmentList.add(new LayoutFragment1());
        fragmentList.add(new LayoutFragment2());
        fragmentList.add(new LayoutFragment3());
        fragmentList.add(new LayoutFragment4());
    }


}
