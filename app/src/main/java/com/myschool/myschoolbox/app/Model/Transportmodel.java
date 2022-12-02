package com.myschool.myschoolbox.app.Model;

public class Transportmodel {
    String vannumber,time,startlocation,lastlocation,drivernumber;

    public Transportmodel() {
    }

    public Transportmodel(String vannumber, String time, String startlocation, String lastlocation, String drivernumber) {
        this.vannumber = vannumber;
        this.time = time;
        this.startlocation = startlocation;
        this.lastlocation = lastlocation;
        this.drivernumber = drivernumber;
    }

    public String getVannumber() {
        return vannumber;
    }

    public void setVannumber(String vannumber) {
        this.vannumber = vannumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getLastlocation() {
        return lastlocation;
    }

    public void setLastlocation(String lastlocation) {
        this.lastlocation = lastlocation;
    }

    public String getDrivernumber() {
        return drivernumber;
    }

    public void setDrivernumber(String drivernumber) {
        this.drivernumber = drivernumber;
    }

    public static class Onlineclassmodel {
        String name,link;

        public Onlineclassmodel() {
        }

        public Onlineclassmodel(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
