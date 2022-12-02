package com.myschool.myschoolbox.app.Model;

public class Tourmodel {
    String placedate,place,url;

    public Tourmodel() {
    }

    public Tourmodel(String placedate, String place, String url) {
        this.placedate = placedate;
        this.place = place;
        this.url = url;
    }

    public String getPlacedate() {
        return placedate;
    }

    public void setPlacedate(String placedate) {
        this.placedate = placedate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
