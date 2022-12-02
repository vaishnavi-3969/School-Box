package com.myschool.myschoolbox.app.Model;

public class Noticemodel {
    String noticemonth,url;

    public Noticemodel() {
    }

    public Noticemodel(String noticemonth, String url) {
        this.noticemonth = noticemonth;
        this.url = url;
    }

    public String getNoticemonth() {
        return noticemonth;
    }

    public void setNoticemonth(String noticemonth) {
        this.noticemonth = noticemonth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
