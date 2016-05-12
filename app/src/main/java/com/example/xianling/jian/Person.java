package com.example.xianling.jian;

import cn.bmob.v3.BmobObject;

/**
 * Created by xianling on 2016/3/3.
 */
public class Person extends BmobObject {
    private String author;
    private String title;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
