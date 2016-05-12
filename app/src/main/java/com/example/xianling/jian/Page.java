package com.example.xianling.jian;

/**
 * Created by xianling on 2016/1/21.
 */
public class Page {
 private String name;
   private int imageId;
    public Page(String name, int imageId){
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
