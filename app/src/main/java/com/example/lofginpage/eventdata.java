package com.example.lofginpage;

public class eventdata {
    private String name,people,work,days,money,location,key;


    public eventdata() {
    }

    public eventdata(String name, String people, String work, String days, String money, String location,String key) {
        this.name = name;
        this.people = people;
        this.work = work;
        this.days = days;
        this.money = money;
        this.location = location;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void key(String key) {
        this.key = key;
    }
}
