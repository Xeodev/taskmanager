
package com.xeocam.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "task")
public class Task implements Serializable {
    public Task() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(generator = "COM_XEOCAM_TASK_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_XEOCAM_TASK_ID_GENERATOR", strategy = "native")
    private int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "usersid", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKtask979092"))
    private Users users;

    @Column(name = "assignedTo", nullable = false, length = 11)
    private int assignedTo;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "detail", nullable = false, length = 2000)
    private String detail;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @OneToMany(mappedBy = "task", targetEntity = Comments.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set comments = new java.util.HashSet();

    private void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public int getORMID() {
        return getId();
    }

    public void setAssignedTo(int value) {
        this.assignedTo = value;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle() {
        return title;
    }

    public void setDetail(String value) {
        this.detail = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getStatus() {
        return status;
    }

    public void setUsers(Users value) {
        this.users = value;
    }

    public Users getUsers() {
        return users;
    }

    public void setComments(java.util.Set value) {
        this.comments = value;
    }

    public java.util.Set getComments() {
        return comments;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}
