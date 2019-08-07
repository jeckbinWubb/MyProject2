package org.techsys.test.model;

import java.util.Date;

public class UserVo {
    private String id;
    private String name;
    private String gender;
    private Date birthday;
    private String certitype;
    private String certicode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCertitype() {
        return certitype;
    }

    public void setCertitype(String certitype) {
        this.certitype = certitype;
    }

    public String getCerticode() {
        return certicode;
    }

    public void setCerticode(String certicode) {
        this.certicode = certicode;
    }
}
