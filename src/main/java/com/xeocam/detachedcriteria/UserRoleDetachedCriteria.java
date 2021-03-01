
package com.xeocam.detachedcriteria;

import java.util.List;

import com.xeocam.criteria.UserRoleCriteria;
import com.xeocam.model.UserRole;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UserRoleDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression roleId;
    public final AssociationExpression role;

    public UserRoleDetachedCriteria() {
        super(UserRole.class, UserRoleCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        roleId = new IntegerExpression("role.id", this.getDetachedCriteria());
        role = new AssociationExpression("role", this.getDetachedCriteria());
    }

    public UserRoleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, UserRoleCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        roleId = new IntegerExpression("role.id", this.getDetachedCriteria());
        role = new AssociationExpression("role", this.getDetachedCriteria());
    }

    public UsersDetachedCriteria createUsersCriteria() {
        return new UsersDetachedCriteria(createCriteria("users"));
    }

    public RoleDetachedCriteria createRoleCriteria() {
        return new RoleDetachedCriteria(createCriteria("role"));
    }

    public UserRole uniqueUserRole(PersistentSession session) {
        return (UserRole) super.createExecutableCriteria(session).uniqueResult();
    }

    public UserRole[] listUserRole(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (UserRole[]) list.toArray(new UserRole[list.size()]);
    }
}

