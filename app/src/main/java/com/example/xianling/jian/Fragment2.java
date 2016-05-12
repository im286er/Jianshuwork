package com.example.xianling.jian;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianling on 2016/1/26.
 */
public class Fragment2 extends Fragment {
    private List<String> list=new ArrayList<String>();
    private String[] data = {"简介", "欢迎页", "用户协议", "隐私政策",
            "简书网                                        www.jianshu.com",
            "新浪微博                                        @简书",
            "微信公众号                                    jianshuio",
            "Twitter                                        jianshucom",
            "诊断网络"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, data);
         ListView listView=(ListView) view.findViewById(R.id.listView5);
        listView.setAdapter(adapter);
        list.add(data[0]);
        list.add(data[1]);
        list.add(data[2]);
        list.add(data[3]);
        list.add(data[4]);
        list.add(data[5]);
        list.add(data[6]);
        list.add(data[7]);
        list.add(data[8]);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals(data[0])) {
                    Intent intent = new Intent(getActivity(), JjActivity.class);
                    startActivity(intent);
                }
                if (list.get(position).equals(data[1])) {
                    Intent intent = new Intent(getActivity(), HyActivity.class);
                    startActivity(intent);
                }
                if (list.get(position).equals(data[2])) {
                    Intent intent = new Intent(getActivity(), YhxyActivity.class);
                    startActivity(intent);
                }
                if (list.get(position).equals(data[3])) {
                    Intent intent = new Intent(getActivity(), YszcActivity.class);
                    startActivity(intent);
                }
                if (list.get(position).equals(data[8])) {
                    AlertDialog.Builder dialog =new AlertDialog.Builder(getActivity());
                    dialog.setTitle("提示");
                    dialog.setMessage("是否traceroute");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(getActivity(),ZdwlActivity.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }

                    });
                    dialog.show();
                }
            }
        });
        return view;

}
        }