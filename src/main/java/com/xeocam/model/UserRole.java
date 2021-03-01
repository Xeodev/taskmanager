
package com.xeocam.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "userRole")
public class UserRole implements Serializable {
    public UserRole() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(generator = "COM_XEOCAM_USERROLE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_XEOCAM_USERROLE_ID_GENERATOR", strategy = "native")
    private int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "usersid", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKuserRole66183"))
    private Users users;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "roleid", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKuserRole441121"))
    private Role role;

    private void setId(int value) {
        this.id = value;
    }

    public int getId() {
        return id;
    }

    public int getORMID() {
        return getId();
    }

    public void setUsers(Users value) {
        this.users = value;
    }

    public Users getUsers() {
        return users;
    }

    public void setRole(Role value) {
        this.role = value;
    }

    public Role getRole() {
        return role;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
