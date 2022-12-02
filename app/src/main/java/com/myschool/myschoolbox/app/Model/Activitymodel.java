package com.myschool.myschoolbox.app.Model;

public class Activitymodel {
    String date,activity,url;

    public Activitymodel() {
    }

    public Activitymodel(String date, String activity, String url) {
        this.date = date;
        this.activity = activity;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
