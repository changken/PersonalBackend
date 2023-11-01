package org.changken.personalspring.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private int age;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
