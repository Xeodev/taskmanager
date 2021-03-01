
package com.xeocam.criteria;

import com.xeocam.TaskmanagementPersistentManager;
import com.xeocam.criteria.TaskCriteria;
import com.xeocam.criteria.UsersCriteria;
import com.xeocam.model.Comments;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentsCriteria extends AbstractORMCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression taskId;
    public final AssociationExpression task;
    public final StringExpression comment;

    public CommentsCriteria(Criteria criteria) {
        super(criteria);
        id = new IntegerExpression("id", this);
        usersId = new IntegerExpression("users.id", this);
        users = new AssociationExpression("users", this);
        taskId = new IntegerExpression("task.id", this);
        task = new AssociationExpression("task", this);
        comment = new StringExpression("comment", this);
    }

    public CommentsCriteria(PersistentSession session) {
        this(session.createCriteria(Comments.class));
    }

    public CommentsCriteria() throws PersistentException {
        this(TaskmanagementPersistentManager.instance().getSession());
    }

    public UsersCriteria createUsersCriteria() {
        return new UsersCriteria(createCriteria("users"));
    }

    public TaskCriteria createTaskCriteria() {
        return new TaskCriteria(createCriteria("task"));
    }

    public Comments uniqueComments() {
        return (Comments) super.uniqueResult();
    }

    public Comments[] listComments() {
        java.util.List list = super.list();
        return (Comments[]) list.toArray(new Comments[list.size()]);
    }
}

