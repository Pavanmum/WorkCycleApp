package com.example.lofginpage;

public class User {

    String Name,Email,Age,Experience,Mobile,qualification;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAge() {
        return Age;
    }

    public String getExperience() {
        return Experience;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getQualification() {
        return qualification;
    }

    public User() {
    }

    public User(String name, String email, String age, String experience, String mobile, String qualification) {
        Name = name;
        Email = email;
        Age = age;
        Experience = experience;
        Mobile = mobile;
        this.qualification = qualification;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
