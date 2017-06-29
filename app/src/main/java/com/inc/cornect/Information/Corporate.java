package com.inc.cornect.Information;

/**
 * Created by sanniAdewale on 13/06/2017.
 */

public class Corporate {

    public String organisation, email, username, password;
    public String type, location, mobile;

    public Corporate(String organisation, String email, String username, String password, String type, String location, String mobile) {
        this.organisation = organisation;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
        this.location = location;
        this.mobile = mobile;
    }

    public Corporate(String organisation, String email, String username, String password) {
        this.organisation = organisation;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Corporate(String type, String location, String mobile) {

        this.type = type;
        this.location = location;
        this.mobile = mobile;
    }


}
