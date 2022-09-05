package com.example.lofginpage.ui;

public class User {
    String Age,Email,Experience,Mobile,Name,qualification;

    public User(String age, String email, String experience, String mobile, String name, String qualification) {
        Age = age;
        Email = email;
        Experience = experience;
        Mobile = mobile;
        Name = name;
        this.qualification = qualification;
    }

    public String getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getExperience() {
        return Experience;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getName() {
        return Name;
    }

    public String getQualification() {
        return qualification;
    }
}
