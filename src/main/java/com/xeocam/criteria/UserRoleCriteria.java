
package com.xeocam.criteria;

import com.xeocam.TaskmanagementPersistentManager;
import com.xeocam.model.UserRole;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UserRoleCriteria extends AbstractORMCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression roleId;
    public final AssociationExpression role;

    public UserRoleCriteria(Criteria criteria) {
        super(criteria);
        id = new IntegerExpression("id", this);
        usersId = new IntegerExpression("users.id", this);
        users = new AssociationExpression("users", this);
        roleId = new IntegerExpression("role.id", this);
        role = new AssociationExpression("role", this);
    }

    public UserRoleCriteria(PersistentSession session) {
        this(session.createCriteria(UserRole.class));
    }

    public UserRoleCriteria() throws PersistentException {
        this(TaskmanagementPersistentManager.instance().getSession());
    }

    public UsersCriteria createUsersCriteria() {
        return new UsersCriteria(createCriteria("users"));
    }

    public RoleCriteria createRoleCriteria() {
        return new RoleCriteria(createCriteria("role"));
    }

    public UserRole uniqueUserRole() {
        return (UserRole) super.uniqueResult();
    }

    public UserRole[] listUserRole() {
        java.util.List list = super.list();
        return (UserRole[]) list.toArray(new UserRole[list.size()]);
    }
}

