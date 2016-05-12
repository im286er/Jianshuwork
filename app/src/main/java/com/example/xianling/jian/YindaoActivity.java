package com.example.xianling.jian;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by xianling on 2016/1/30.
 */
public class YindaoActivity extends Activity {
    private ArrayList<View> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yindao);
        Button button=(Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(YindaoActivity.this,MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("jianshu","1");
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        ViewPager viewPager=(ViewPager) findViewById(R.id.viewPager);
        initViews();
        viewPager.setAdapter(new PageAdapter());}
        public void initViews(){
        arrayList.add(getLayoutInflater().inflate(R.layout.yinfragment1, null));
        arrayList.add(getLayoutInflater().inflate(R.layout.yinfragment2, null));
        arrayList.add(getLayoutInflater().inflate(R.layout.yinfragment3, null));

    }
    public class PageAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v=arrayList.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(arrayList.get(position));
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

}

