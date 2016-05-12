package com.example.xianling.jian;

import android.annotation.TargetApi;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/1/21.
 */
public class Top1Activity extends Fragment {
    String[] data = {"热门", "新上榜", "连载", "生活家", "世间事", "@IT", "视频", "七嘴八舌", "电影", "经典", "读图", "市集", "七日热门", "三十日热门"};
    private List<Fragment> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top1, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view.findViewById(R.id.pageTabStrip);
        initViews();
        viewPager.setAdapter(new PageAdapter(getChildFragmentManager()));
        return view;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void initViews() {
        arrayList.add(new Top1FragmentActivity());
        arrayList.add(new Top2FragmentActivity());
        arrayList.add(new Top3FragmentActivity());
        arrayList.add(new Top4FragmentActivity());
        arrayList.add(new Top5FragmentActivity());
        arrayList.add(new Top6FragmentActivity());
        arrayList.add(new Top7FragmentActivity());
        arrayList.add(new Top8FragmentActivity());
        arrayList.add(new Top9FragmentActivity());
        arrayList.add(new Top10FragmentActivity());
        arrayList.add(new Top11FragmentActivity());
        arrayList.add(new Top12FragmentActivity());
        arrayList.add(new Top13FragmentActivity());
        arrayList.add(new Top14FragmentActivity());

    }

    public class PageAdapter extends FragmentPagerAdapter {
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override

        public CharSequence getPageTitle(int position) {
            return data[position];
        }

        @Override
        public Fragment getItem(int position) {
            return arrayList.get(position);
        }


        @Override
        public int getCount() {
            return arrayList.size();
        }


    }
}
