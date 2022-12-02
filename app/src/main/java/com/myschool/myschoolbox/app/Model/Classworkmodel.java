package com.myschool.myschoolbox.app.Model;

public class Classworkmodel {
    String subject,date,heading,note,classname,url;

    public Classworkmodel() {
    }

    public Classworkmodel(String subject, String date, String heading, String note, String classname, String url) {
        this.subject = subject;
        this.date = date;
        this.heading = heading;
        this.note = note;
        this.classname = classname;
        this.url = url;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
