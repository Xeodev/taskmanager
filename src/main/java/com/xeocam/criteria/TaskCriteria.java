
package com.xeocam.criteria;

import com.xeocam.TaskmanagementPersistentManager;
import com.xeocam.model.Task;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TaskCriteria extends AbstractORMCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression assignedTo;
    public final StringExpression title;
    public final StringExpression detail;
    public final StringExpression status;
    public final CollectionExpression comments;

    public TaskCriteria(Criteria criteria) {
        super(criteria);
        id = new IntegerExpression("id", this);
        usersId = new IntegerExpression("users.id", this);
        users = new AssociationExpression("users", this);
        assignedTo = new IntegerExpression("assignedTo", this);
        title = new StringExpression("title", this);
        detail = new StringExpression("detail", this);
        status = new StringExpression("status", this);
        comments = new CollectionExpression("comments", this);
    }

    public TaskCriteria(PersistentSession session) {
        this(session.createCriteria(Task.class));
    }

    public TaskCriteria() throws PersistentException {
        this(TaskmanagementPersistentManager.instance().getSession());
    }

    public UsersCriteria createUsersCriteria() {
        return new UsersCriteria(createCriteria("users"));
    }

    public CommentsCriteria createCommentsCriteria() {
        return new CommentsCriteria(createCriteria("comments"));
    }

    public Task uniqueTask() {
        return (Task) super.uniqueResult();
    }

    public Task[] listTask() {
        java.util.List list = super.list();
        return (Task[]) list.toArray(new Task[list.size()]);
    }
}

