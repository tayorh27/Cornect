package com.inc.cornect.Information;

/**
 * Created by sanniAdewale on 13/06/2017.
 */

public class Personal {

    public String first_name, middle_name, last_name, dob, sex, mobile;
    public String location, country, citizenship, email, username, password;
    public String high_school, cpu, discipline, college, uni, uni_location, level;
    public String picture, hobbies, likes, dislikes, interests;

    public Personal(String first_name, String middle_name, String last_name, String dob, String sex, String mobile) {

        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.dob = dob;
        this.sex = sex;
        this.mobile = mobile;
    }

    public Personal(String location, String country, String citizenship, String email, String username, String password, String nth) {

        this.location = location;
        this.country = country;
        this.citizenship = citizenship;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Personal(String high_school, String cpu, String discipline, String college, String uni, String uni_location, String level, String nth) {

        this.high_school = high_school;
        this.cpu = cpu;
        this.discipline = discipline;
        this.college = college;
        this.uni = uni;
        this.uni_location = uni_location;
        this.level = level;
    }

    public Personal(String picture, String hobbies, String likes, String dislikes, String interests) {
        this.picture = picture;
        this.hobbies = hobbies;
        this.likes = likes;
        this.dislikes = dislikes;
        this.interests = interests;
    }

    public Personal(String first_name, String middle_name, String last_name, String dob, String sex, String mobile,
                    String location, String country, String citizenship, String email, String username, String password,
                    String high_school, String cpu, String discipline, String college, String uni, String uni_location, String level,
                    String picture, String hobbies, String likes, String dislikes, String interests) {

        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.dob = dob;
        this.sex = sex;
        this.mobile = mobile;
        this.location = location;
        this.country = country;
        this.citizenship = citizenship;
        this.email = email;
        this.username = username;
        this.password = password;
        this.high_school = high_school;
        this.cpu = cpu;
        this.discipline = discipline;
        this.college = college;
        this.uni = uni;
        this.uni_location = uni_location;
        this.level = level;
        this.picture = picture;
        this.hobbies = hobbies;
        this.likes = likes;
        this.dislikes = dislikes;
        this.interests = interests;
    }
}
