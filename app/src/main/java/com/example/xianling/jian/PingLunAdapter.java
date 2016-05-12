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
 * Created by xianling on 2016/3/4.
 */
public class PingLunAdapter extends BaseAdapter{
    private List<Person3> list=new ArrayList<>();
    private Context context;
    public PingLunAdapter(Context context,List<Person3> list) {
        this.context = context;
        this.list = list;
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
        View view=inflater.inflate(R.layout.item_pinglun, null);
        TextView textView1=(TextView) view.findViewById(R.id.textView_ping);
        TextView textView2=(TextView) view.findViewById(R.id.textView_shi);
        textView1.setText(list.get(position).getContect());
        textView2.setText(list.get(position).getCreatedAt());
        return view;
    }
}
