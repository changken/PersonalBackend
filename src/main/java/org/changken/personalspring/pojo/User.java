package org.changken.personalspring.pojo;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Table(name = "usertbl")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nid")
    private Long id;
    @Column(name="vchusername")
    private String username;
    @Column(name="vchpassword")
    private String password;
    @Column(name="vchlevel")
    private String level;
    @Column(name="dbirthday")
    private Date birthday;
    @CreatedDate
    @Column(name="dcreated_at")
    private Date created_at;
    @LastModifiedDate
    @Column(name="dupdated_at")
    private Date updated_at;

    public User() {
    }

    public User(Long id, String username, String password, String level, Date birthday, Date created_at, Date updated_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.birthday = birthday;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
