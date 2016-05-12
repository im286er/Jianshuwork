package com.example.xianling.jian;

import android.content.Intent;
import android.os.Bundle;
;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/2/26.
 */
public class MyPageActivity extends FragmentActivity {
    String[] data ={"动态", "文章","简介" };
    ViewPager mPager;
    PageIndicator mIndicator;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypageactivity);
        Button button=(Button) findViewById(R.id.button_bianji);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyPageActivity.this,BianjiActivity.class);
                startActivity(intent);
            }
        });
        initFragment();
        initView();
    }
    private void initFragment(){
        fragmentList.add(new FragmentMy1Activity());
        fragmentList.add(new FragmentMy2Activity());
        fragmentList.add(new FragmentMy3Activity());
    }
    private void initView(){
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(adapter);
        mIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}
