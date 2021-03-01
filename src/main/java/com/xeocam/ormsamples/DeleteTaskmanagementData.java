
package com.xeocam.ormsamples;

import com.xeocam.model.*;
import org.orm.*;

public class DeleteTaskmanagementData {
    public void deleteTestData() throws PersistentException {
        PersistentTransaction t = com.xeocam.TaskmanagementPersistentManager.instance().getSession().beginTransaction();
        try {
            Comments lcomxeocamComments = (Comments) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Comments").setMaxResults(1).uniqueResult();
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().delete(lcomxeocamComments);

            Task lcomxeocamTask = (Task) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Task").setMaxResults(1).uniqueResult();
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().delete(lcomxeocamTask);

            Users lcomxeocamUsers = (Users) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Users").setMaxResults(1).uniqueResult();
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().delete(lcomxeocamUsers);

            Role lcomxeocamRole = (Role) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Role").setMaxResults(1).uniqueResult();
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().delete(lcomxeocamRole);

            UserRole lcomxeocamUserRole = (UserRole) com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.UserRole").setMaxResults(1).uniqueResult();
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().delete(lcomxeocamUserRole);

            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }

    public static void main(String[] args) {
        try {
            DeleteTaskmanagementData deleteTaskmanagementData = new DeleteTaskmanagementData();
            try {
                deleteTaskmanagementData.deleteTestData();
            } finally {
                com.xeocam.TaskmanagementPersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
