package com.example.xianling.jian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class PageAdapter extends ArrayAdapter<Page> {
  private int resourceId;
    public PageAdapter(Context context,int textViewResourceId,
                        List<Page> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Page page=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView pageImage=(ImageView) view.findViewById(R.id.page_image);
        TextView pageName=(TextView) view.findViewById(R.id.page_name);
        pageImage.setImageResource(page.getImageId());
        pageName.setText((CharSequence) page.getName());
        return view;
    }
}
