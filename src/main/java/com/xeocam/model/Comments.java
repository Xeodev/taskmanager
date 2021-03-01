
package com.xeocam.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "comments")
public class Comments implements Serializable {
    public Comments() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(generator = "COM_XEOCAM_COMMENTS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_XEOCAM_COMMENTS_ID_GENERATOR", strategy = "native")
    private int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "usersid", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKcomments947971"))
    private Users users;

    @ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "taskid", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKcomments733203"))
    private Task task;

    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    private void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public int getORMID() {
        return getId();
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public String getComment() {
        return comment;
    }

    public void setUsers(Users value) {
        this.users = value;
    }

    public Users getUsers() {
        return users;
    }

    public void setTask(Task value) {
        this.task = value;
    }

    public Task getTask() {
        return task;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
