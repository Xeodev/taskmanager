
package com.xeocam.criteria;

import com.xeocam.TaskmanagementPersistentManager;
import com.xeocam.model.Users;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UsersCriteria extends AbstractORMCriteria {
    public final IntegerExpression id;
    public final StringExpression userName;
    public final StringExpression password;
    public final StringExpression firstName;
    public final StringExpression lastName;
    public final BooleanExpression enabled;
    public final CollectionExpression comments;
    public final CollectionExpression userRole;
    public final CollectionExpression task;

    public UsersCriteria(Criteria criteria) {
        super(criteria);
        id = new IntegerExpression("id", this);
        userName = new StringExpression("userName", this);
        password = new StringExpression("password", this);
        firstName = new StringExpression("firstName", this);
        lastName = new StringExpression("lastName", this);
        enabled = new BooleanExpression("enabled", this);
        comments = new CollectionExpression("comments", this);
        userRole = new CollectionExpression("userRole", this);
        task = new CollectionExpression("task", this);
    }

    public UsersCriteria(PersistentSession session) {
        this(session.createCriteria(Users.class));
    }

    public UsersCriteria() throws PersistentException {
        this(TaskmanagementPersistentManager.instance().getSession());
    }

    public CommentsCriteria createCommentsCriteria() {
        return new CommentsCriteria(createCriteria("comments"));
    }

    public UserRoleCriteria createUserRoleCriteria() {
        return new UserRoleCriteria(createCriteria("userRole"));
    }

    public TaskCriteria createTaskCriteria() {
        return new TaskCriteria(createCriteria("task"));
    }

    public Users uniqueUsers() {
        return (Users) super.uniqueResult();
    }

    public Users[] listUsers() {
        java.util.List list = super.list();
        return (Users[]) list.toArray(new Users[list.size()]);
    }
}

