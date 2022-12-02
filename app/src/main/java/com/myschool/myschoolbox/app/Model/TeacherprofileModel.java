package com.myschool.myschoolbox.app.Model;

public class TeacherprofileModel {
    String url,teachername,ocupation;

    public TeacherprofileModel() {
    }

    public TeacherprofileModel(String url, String teachername, String ocupation) {
        this.url = url;
        this.teachername = teachername;
        this.ocupation = ocupation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }
}
