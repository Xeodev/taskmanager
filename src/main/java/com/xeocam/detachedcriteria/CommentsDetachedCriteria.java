
package com.xeocam.detachedcriteria;

import java.util.List;

import com.xeocam.criteria.CommentsCriteria;
import com.xeocam.model.Comments;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentsDetachedCriteria extends AbstractORMDetachedCriteria {
    public final IntegerExpression id;
    public final IntegerExpression usersId;
    public final AssociationExpression users;
    public final IntegerExpression taskId;
    public final AssociationExpression task;
    public final StringExpression comment;

    public CommentsDetachedCriteria() {
        super(Comments.class, CommentsCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        taskId = new IntegerExpression("task.id", this.getDetachedCriteria());
        task = new AssociationExpression("task", this.getDetachedCriteria());
        comment = new StringExpression("comment", this.getDetachedCriteria());
    }

    public CommentsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
        super(aDetachedCriteria, CommentsCriteria.class);
        id = new IntegerExpression("id", this.getDetachedCriteria());
        usersId = new IntegerExpression("users.id", this.getDetachedCriteria());
        users = new AssociationExpression("users", this.getDetachedCriteria());
        taskId = new IntegerExpression("task.id", this.getDetachedCriteria());
        task = new AssociationExpression("task", this.getDetachedCriteria());
        comment = new StringExpression("comment", this.getDetachedCriteria());
    }

    public UsersDetachedCriteria createUsersCriteria() {
        return new UsersDetachedCriteria(createCriteria("users"));
    }

    public TaskDetachedCriteria createTaskCriteria() {
        return new TaskDetachedCriteria(createCriteria("task"));
    }

    public Comments uniqueComments(PersistentSession session) {
        return (Comments) super.createExecutableCriteria(session).uniqueResult();
    }

    public Comments[] listComments(PersistentSession session) {
        List list = super.createExecutableCriteria(session).list();
        return (Comments[]) list.toArray(new Comments[list.size()]);
    }
}

