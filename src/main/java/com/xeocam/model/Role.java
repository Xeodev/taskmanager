
package com.xeocam.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "role")
public class Role implements Serializable {
    public Role() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(generator = "COM_XEOCAM_ROLE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_XEOCAM_ROLE_ID_GENERATOR", strategy = "native")
    private int id;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    @OneToMany(mappedBy = "role", targetEntity = UserRole.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set userRole = new java.util.HashSet();

    private void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public int getORMID() {
        return getId();
    }

    public void setRole(String value) {
        this.role = value;
    }

    public String getRole() {
        return role;
    }

    public void setUserRole(java.util.Set value) {
        this.userRole = value;
    }

    public java.util.Set getUserRole() {
        return userRole;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}
