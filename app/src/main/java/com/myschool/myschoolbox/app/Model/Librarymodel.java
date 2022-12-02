package com.myschool.myschoolbox.app.Model;

public class Librarymodel {
    String mont,url;

    public Librarymodel() {
    }

    public Librarymodel(String mont, String url) {
        this.mont = mont;
        this.url = url;
    }

    public String getMont() {
        return mont;
    }

    public void setMont(String mont) {
        this.mont = mont;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
