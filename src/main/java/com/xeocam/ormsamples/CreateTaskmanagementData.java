
package com.xeocam.ormsamples;

import com.xeocam.model.*;
import org.orm.*;

public class CreateTaskmanagementData {
    public void createTestData() throws PersistentException {
        PersistentTransaction t = com.xeocam.TaskmanagementPersistentManager.instance().getSession().beginTransaction();
        try {
            Comments lcomxeocamComments = new Comments();            // TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : comment, task, users
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().save(lcomxeocamComments);

            Task lcomxeocamTask = new Task();            // TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : comments, status, detail, title, assignedTo, users
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().save(lcomxeocamTask);

            Users lcomxeocamUsers = new Users();            // TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : task, userRole, comments, enabled, lastName, firstName, password, userName
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().save(lcomxeocamUsers);

            Role lcomxeocamRole = new Role();            // TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : userRole, role
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().save(lcomxeocamRole);

            UserRole lcomxeocamUserRole = new UserRole();            // TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : role, users
            com.xeocam.TaskmanagementPersistentManager.instance().getSession().save(lcomxeocamUserRole);

            t.commit();
        } catch (Exception e) {
            t.rollback();
        }

    }

    public static void main(String[] args) {
        try {
            CreateTaskmanagementData createTaskmanagementData = new CreateTaskmanagementData();
            try {
                createTaskmanagementData.createTestData();
            } finally {
                com.xeocam.TaskmanagementPersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
