package com.example.xianling.jian.mode;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xianling.jian.LayoutFragment1;
import com.example.xianling.jian.LayoutFragment2;
import com.example.xianling.jian.LayoutFragment3;
import com.example.xianling.jian.LayoutFragment4;
import com.example.xianling.jian.R;
import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/4/22.
 */
public class TestActivity extends AppCompatActivity{
    private ViewPager pager;
    private PageIndicator indicator;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
        pager=(ViewPager)findViewById(R.id.mypager);
        indicator=(PageIndicator)findViewById(R.id.myindicator);

        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        indicator.setViewPager(pager);
    }

    private void init(){
        fragmentList.add(new LayoutFragment1());
        fragmentList.add(new LayoutFragment2());
        fragmentList.add(new LayoutFragment3());
    }
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
}
