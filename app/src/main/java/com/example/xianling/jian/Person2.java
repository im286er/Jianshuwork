package com.example.xianling.jian;

import cn.bmob.v3.BmobObject;

/**
 * Created by xianling on 2016/3/3.
 */
public class Person2 extends BmobObject{
    private String context;
    private String tel;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
