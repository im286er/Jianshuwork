package com.example.xianling.jian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/3/3.
 */
public class PersonAdapter extends BaseAdapter{
    private List<Person> list=new ArrayList<>();
    private Context context;
    private TextView textView1,textView2,textView3;
    public PersonAdapter(Context context,List<Person> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_person,null);
        textView1=(TextView) view.findViewById(R.id.textView_author);
        textView2=(TextView) view.findViewById(R.id.textView_title);
        textView3=(TextView) view.findViewById(R.id.textView_time);
        textView3.setText(list.get(position).getCreatedAt());
        textView1.setText(list.get(position).getAuthor());
        textView2.setText(list.get(position).getTitle());
        return view;
    }
}
