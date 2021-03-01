
package com.xeocam.ormsamples;

import com.xeocam.criteria.*;
import com.xeocam.model.*;
import org.orm.*;

public class RetrieveAndUpdateTaskmanagementData {
    public void retrieveAndUpdateTestData() throws PersistentException {
        PersistentTransaction t = com.xeocam.TaskmanagementPersistentManager.instance().getSession().beginTransaction();
        try {
            Comments lcomxeocamComments = (Comments) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Comments").setMaxResults(1).uniqueResult();
            // Update the properties of the persistent object
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().update(lcomxeocamComments);

            Task lcomxeocamTask = (Task) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Task").setMaxResults(1).uniqueResult();
            // Update the properties of the persistent object
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().update(lcomxeocamTask);

            Users lcomxeocamUsers = (Users) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Users").setMaxResults(1).uniqueResult();
            // Update the properties of the persistent object
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().update(lcomxeocamUsers);

            Role lcomxeocamRole = (Role) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Role").setMaxResults(1).uniqueResult();
            // Update the properties of the persistent object
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().update(lcomxeocamRole);

            UserRole lcomxeocamUserRole = (UserRole) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.UserRole").setMaxResults(1).uniqueResult();
            // Update the properties of the persistent object
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().update(lcomxeocamUserRole);

            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }

    public void retrieveByCriteria() throws PersistentException {
        System.out.println("Retrieving Comments by CommentsCriteria");
        CommentsCriteria lcomxeocamCommentsCriteria = new CommentsCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamCommentsCriteria.id.eq();
        System.out.println(lcomxeocamCommentsCriteria.uniqueComments());

        System.out.println("Retrieving Task by TaskCriteria");
        TaskCriteria lcomxeocamTaskCriteria = new TaskCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamTaskCriteria.id.eq();
        System.out.println(lcomxeocamTaskCriteria.uniqueTask());

        System.out.println("Retrieving Users by UsersCriteria");
        UsersCriteria lcomxeocamUsersCriteria = new UsersCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamUsersCriteria.id.eq();
        System.out.println(lcomxeocamUsersCriteria.uniqueUsers());

        System.out.println("Retrieving Role by RoleCriteria");
        RoleCriteria lcomxeocamRoleCriteria = new RoleCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamRoleCriteria.id.eq();
        System.out.println(lcomxeocamRoleCriteria.uniqueRole());

        System.out.println("Retrieving UserRole by UserRoleCriteria");
        UserRoleCriteria lcomxeocamUserRoleCriteria = new UserRoleCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamUserRoleCriteria.id.eq();
        System.out.println(lcomxeocamUserRoleCriteria.uniqueUserRole());

    }


    public static void main(String[] args) {
        try {
            RetrieveAndUpdateTaskmanagementData retrieveAndUpdateTaskmanagementData = new RetrieveAndUpdateTaskmanagementData();
            try {
                retrieveAndUpdateTaskmanagementData.retrieveAndUpdateTestData();
                //retrieveAndUpdateTaskmanagementData.retrieveByCriteria();
            } finally {
                com.xeocam.TaskmanagementPersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
