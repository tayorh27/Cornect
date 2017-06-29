package com.inc.cornect.Database;

import android.content.Context;
import android.content.SharedPreferences;

import com.inc.cornect.Information.Corporate;
import com.inc.cornect.Information.Personal;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class AppData {

    Context context;
    SharedPreferences prefs;

    public AppData(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("", 0);
    }

    public void SetPersonalInfo_one(Personal personal) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("first_name", personal.first_name);
        editor.putString("middle_name", personal.middle_name);
        editor.putString("last_name", personal.last_name);
        editor.putString("dob", personal.dob);
        editor.putString("sex", personal.sex);
        editor.putString("mobile", personal.mobile);
        editor.apply();
    }

    public void SetPersonalInfo_two(Personal personal) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("location", personal.location);
        editor.putString("country", personal.country);
        editor.putString("citizenship", personal.citizenship);
        editor.putString("email", personal.email);
        editor.putString("username", personal.username);
        editor.putString("password", personal.password);
        editor.apply();
    }

    public void SetPersonalInfo_three(Personal personal) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("high_school", personal.high_school);
        editor.putString("cpu", personal.cpu);
        editor.putString("discipline", personal.discipline);
        editor.putString("college", personal.college);
        editor.putString("uni", personal.uni);
        editor.putString("uni_location", personal.uni_location);
        editor.putString("level", personal.level);
        editor.apply();
    }

    public void SetPersonalInfo_four(Personal personal) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("picture", personal.picture);
        editor.putString("hobbies", personal.hobbies);
        editor.putString("likes", personal.likes);
        editor.putString("dislikes", personal.dislikes);
        editor.putString("interests", personal.interests);
        editor.apply();
    }

    public Personal getPersonalInfo() {
        String first_name = prefs.getString("first_name", "");
        String middle_name = prefs.getString("middle_name", "");
        String last_name = prefs.getString("last_name", "");
        String dob = prefs.getString("dob", "");
        String sex = prefs.getString("sex", "");
        String mobile = prefs.getString("mobile", "");
        String location = prefs.getString("location", "");
        String country = prefs.getString("country", "");
        String citizenship = prefs.getString("citizenship", "");
        String email = prefs.getString("email", "");
        String username = prefs.getString("username", "");
        String password = prefs.getString("password", "");
        String high_school = prefs.getString("high_school", "");
        String cpu = prefs.getString("cpu", "");
        String discipline = prefs.getString("discipline", "");
        String college = prefs.getString("college", "");
        String uni = prefs.getString("uni", "");
        String uni_location = prefs.getString("uni_location", "");
        String level = prefs.getString("level", "");
        String picture = prefs.getString("picture", "");
        String hobbies = prefs.getString("hobbies", "");
        String likes = prefs.getString("likes", "");
        String dislikes = prefs.getString("dislikes", "");
        String interests = prefs.getString("interests", "");
        return new Personal(first_name, middle_name, last_name, dob, sex, mobile,
                location, country, citizenship, email, username, password,
                high_school, cpu, discipline, college, uni, uni_location, level,
                picture, hobbies, likes, dislikes, interests);
    }

    public void setCorporateInfo_one(Corporate corporate) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("organisation", corporate.organisation);
        editor.putString("c_email", corporate.email);
        editor.putString("c_username", corporate.username);
        editor.putString("c_password", corporate.password);
        editor.apply();
    }

    public void setCorporateInfo_two(Corporate corporate) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("type", corporate.type);
        editor.putString("c_location", corporate.location);
        editor.putString("c_mobile", corporate.mobile);
        editor.apply();
    }

    public Corporate getCorporateInfo() {
        String organisation = prefs.getString("organisation", "");
        String email = prefs.getString("c_email", "");
        String username = prefs.getString("c_username", "");
        String password = prefs.getString("c_password", "");
        String type = prefs.getString("type", "");
        String location = prefs.getString("c_location", "");
        String mobile = prefs.getString("c_mobile", "");
        return new Corporate(organisation, email, username, password, type, location, mobile);
    }

    public void setLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("logged", loggedIn);
        editor.apply();
    }

    public boolean getLoggedIn() {
        return prefs.getBoolean("logged", false);
    }
}
