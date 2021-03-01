
package com.xeocam.detachedcriteria;

import java.util.List;

import com.xeocam.criteria.TaskCriteria;
import com.xeocam.model.Task;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TaskDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression assignedTo;
    public final StringExpression title;
    public final StringExpression detail;
    public final StringExpression status;
    public final CollectionExpression comments;

    public TaskDetachedCriteria() {
        super(Task.class, TaskCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        assignedTo = new IntegerExpression("assignedTo", this.getDetachedCriteria());
        title = new StringExpression("title", this.getDetachedCriteria());
        detail = new StringExpression("detail", this.getDetachedCriteria());
        status = new StringExpression("status", this.getDetachedCriteria());
        comments = new CollectionExpression("comments", this.getDetachedCriteria());
    }

    public TaskDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, TaskCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        assignedTo = new IntegerExpression("assignedTo", this.getDetachedCriteria());
        title = new StringExpression("title", this.getDetachedCriteria());
        detail = new StringExpression("detail", this.getDetachedCriteria());
        status = new StringExpression("status", this.getDetachedCriteria());
        comments = new CollectionExpression("comments", this.getDetachedCriteria());
    }

    public UsersDetachedCriteria createUsersCriteria() {
        return new UsersDetachedCriteria(createCriteria("users"));
    }

    public CommentsDetachedCriteria createCommentsCriteria() {
        return new CommentsDetachedCriteria(createCriteria("comments"));
    }

    public Task uniqueTask(PersistentSession session) {
        return (Task) super.createExecutableCriteria(session).uniqueResult();
    }

    public Task[] listTask(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Task[]) list.toArray(new Task[list.size()]);
    }
}

