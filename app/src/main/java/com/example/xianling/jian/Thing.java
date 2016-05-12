package com.example.xianling.jian;

/**
 * Created by xianling on 2016/1/22.
 */
public class Thing {
    private String name;
    private int imageId;
    public Thing(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
