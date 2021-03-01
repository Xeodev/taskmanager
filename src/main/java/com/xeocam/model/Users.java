
package com.xeocam.model;

import com.xeocam.model.Comments;
import com.xeocam.model.Task;
import com.xeocam.model.UserRole;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "users")
public class Users implements Serializable {
    public Users() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(generator = "COM_XEOCAM_USERS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_XEOCAM_USERS_ID_GENERATOR", strategy = "native")
    private int id;

    @Column(name = "userName", nullable = false, length = 45)
    private String userName;

    @Column(name = "password", nullable = false, length = 300)
    private String password;

    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Column(name = "enabled", nullable = false, length = 4)
    private boolean enabled;

    @OneToMany(mappedBy = "users", targetEntity = Comments.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set comments = new java.util.HashSet();

    @OneToMany(mappedBy = "users", targetEntity = UserRole.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set userRole = new java.util.HashSet();

    @OneToMany(mappedBy = "users", targetEntity = Task.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set task = new java.util.HashSet();

    private void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public int getORMID() {
        return getId();
    }

    public void setUserName(String value) {
        this.userName = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setComments(java.util.Set value) {
        this.comments = value;
    }

    public java.util.Set getComments() {
        return comments;
    }


    public void setUserRole(java.util.Set value) {
        this.userRole = value;
    }

    public java.util.Set getUserRole() {
        return userRole;
    }


    public void setTask(java.util.Set value) {
        this.task = value;
    }

    public java.util.Set getTask() {
        return task;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}
