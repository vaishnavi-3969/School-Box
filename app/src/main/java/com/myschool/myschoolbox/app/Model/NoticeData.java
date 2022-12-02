package com.myschool.myschoolbox.app.Model;

public class NoticeData {
    String title, image, data, time, key;
    public NoticeData(){

    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public String getKey() {
        return key;
    }

    public NoticeData(String title, String image, String data, String time, String key) {
        this.title = title;
        this.image = image;
        this.data = data;
        this.time = time;
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setKey(String key) {
        this.key = key;
    }
}