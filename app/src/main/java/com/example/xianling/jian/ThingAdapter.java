package com.example.xianling.jian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class ThingAdapter extends ArrayAdapter<Thing> {
    private int resourceId;
    public ThingAdapter(Context context,int textViewResourceId,
                       List<Thing> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Thing thing=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView thingImage=(ImageView) view.findViewById(R.id.thing_image);
        TextView thingName=(TextView) view.findViewById(R.id.thing_name);
        thingImage.setImageResource(thing.getImageId());
        thingName.setText(thing.getName());
        return view;
    }
}

