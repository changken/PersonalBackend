package org.changken.personalspring.pojo;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Table(name="memotbl")
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nid")
    private Long id;

    @Column(name="vchtitle")
    private String title;

    @Column(name="vchcontent")
    private String content;

    @Column(name="nis_did")
    private int isDid;

    @Column(name="nuserid")
    private long userId;

    @CreatedDate
    @Column(name="dcreated_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name="dupdated_at")
    private Date updatedAt;

    public Memo(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsDid() {
        return isDid;
    }

    public void setIsDid(int isDid) {
        this.isDid = isDid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
