
package com.xeocam.criteria;

import com.xeocam.TaskmanagementPersistentManager;
import com.xeocam.model.Role;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RoleCriteria extends AbstractORMCriteria {
    public final IntegerExpression id;
    public final StringExpression role;
    public final CollectionExpression userRole;

    public RoleCriteria(Criteria criteria) {
        super(criteria);
        id = new IntegerExpression("id", this);
        role = new StringExpression("role", this);
        userRole = new CollectionExpression("userRole", this);
    }

    public RoleCriteria(PersistentSession session) {
        this(session.createCriteria(Role.class));
    }

    public RoleCriteria() throws PersistentException {
        this(TaskmanagementPersistentManager.instance().getSession());
    }

    public UserRoleCriteria createUserRoleCriteria() {
        return new UserRoleCriteria(createCriteria("userRole"));
    }

    public Role uniqueRole() {
        return (Role) super.uniqueResult();
    }

    public Role[] listRole() {
        java.util.List list = super.list();
        return (Role[]) list.toArray(new Role[list.size()]);
    }
}

