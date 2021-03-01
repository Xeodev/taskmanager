
package com.xeocam.detachedcriteria;

import java.util.List;

import com.xeocam.criteria.UsersCriteria;
import com.xeocam.model.Users;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UsersDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression id;
    public final StringExpression userName;
    public final StringExpression password;
    public final StringExpression firstName;
    public final StringExpression lastName;
    public final BooleanExpression enabled;
    public final CollectionExpression comments;
    public final CollectionExpression userRole;
    public final CollectionExpression task;

    public UsersDetachedCriteria() {
        super(Users.class, UsersCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        userName = new StringExpression("userName", this.getDetachedCriteria());
        password = new StringExpression("password", this.getDetachedCriteria());
        firstName = new StringExpression("firstName", this.getDetachedCriteria());
        lastName = new StringExpression("lastName", this.getDetachedCriteria());
        enabled = new BooleanExpression("enabled", this.getDetachedCriteria());
        comments = new CollectionExpression("comments", this.getDetachedCriteria());
        userRole = new CollectionExpression("userRole", this.getDetachedCriteria());
        task = new CollectionExpression("task", this.getDetachedCriteria());
    }

    public UsersDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, UsersCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        userName = new StringExpression("userName", this.getDetachedCriteria());
        password = new StringExpression("password", this.getDetachedCriteria());
        firstName = new StringExpression("firstName", this.getDetachedCriteria());
        lastName = new StringExpression("lastName", this.getDetachedCriteria());
        enabled = new BooleanExpression("enabled", this.getDetachedCriteria());
        comments = new CollectionExpression("comments", this.getDetachedCriteria());
        userRole = new CollectionExpression("userRole", this.getDetachedCriteria());
        task = new CollectionExpression("task", this.getDetachedCriteria());
    }

    public CommentsDetachedCriteria createCommentsCriteria() {
        return new CommentsDetachedCriteria(createCriteria("comments"));
    }

    public UserRoleDetachedCriteria createUserRoleCriteria() {
        return new UserRoleDetachedCriteria(createCriteria("userRole"));
    }

    public TaskDetachedCriteria createTaskCriteria() {
        return new TaskDetachedCriteria(createCriteria("task"));
    }

    public Users uniqueUsers(PersistentSession session) {
        return (Users) super.createExecutableCriteria(session).uniqueResult();
    }

    public Users[] listUsers(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Users[]) list.toArray(new Users[list.size()]);
    }
}

