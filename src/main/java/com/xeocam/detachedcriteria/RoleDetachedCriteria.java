
package com.xeocam.detachedcriteria;

import java.util.List;

import com.xeocam.criteria.RoleCriteria;
import com.xeocam.model.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RoleDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression id;
    public final StringExpression role;
    public final CollectionExpression userRole;

    public RoleDetachedCriteria() {
        super(Role.class, RoleCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        role = new StringExpression("role", this.getDetachedCriteria());
        userRole = new CollectionExpression("userRole", this.getDetachedCriteria());
    }

    public RoleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, RoleCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        role = new StringExpression("role", this.getDetachedCriteria());
        userRole = new CollectionExpression("userRole", this.getDetachedCriteria());
    }

    public UserRoleDetachedCriteria createUserRoleCriteria() {
        return new UserRoleDetachedCriteria(createCriteria("userRole"));
    }

    public Role uniqueRole(PersistentSession session) {
        return (Role) super.createExecutableCriteria(session).uniqueResult();
    }

    public Role[] listRole(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Role[]) list.toArray(new Role[list.size()]);
    }
}

