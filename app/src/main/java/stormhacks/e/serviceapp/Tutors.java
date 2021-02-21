package stormhacks.e.serviceapp;

import java.util.HashMap;

public class Tutors {

    String name;
    String email;
    String phone;
    String title;
    int rate;
    int[] availability;
    boolean math,science,english,socials;
    String description;

    public Tutors(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tutors(String name, String email, String phone, String title, int rate, Boolean math, Boolean science, Boolean english, Boolean socials, String description) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.rate = rate;
        //this.availability = availability;
        this.math = math;
        this.science = science;
        this.english = english;
        this.socials = socials;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    public int getRate() {
        return rate;
    }

//    public int[] getAvailability() {
//        return availability;
//    }

    public Boolean getMath() {
        return math;
    }

    public Boolean getScience() {
        return science;
    }

    public Boolean getEnglish() {
        return english;
    }

    public Boolean getSocials() {
        return socials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

//    public void setAvailability(int[] availability) {
//        this.availability = availability;
//    }

    public void setMath(Boolean math) {
        this.math = math;
    }

    public void setScience(Boolean science) {
        this.science = science;
    }

    public void setEnglish(Boolean english) {
        this.english = english;
    }

    public void setSocials(Boolean socials) {
        this.socials = socials;
    }

    @Override
    public String toString(){
        return name + " "+ email+" "+
                rate+" "+title;
    }
}

