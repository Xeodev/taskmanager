
package com.xeocam.ormsamples;

import com.xeocam.criteria.*;
import com.xeocam.model.*;
import org.orm.*;

public class ListTaskmanagementData {
    private static final int ROW_COUNT = 100;

    public void listTestData() throws PersistentException {
        System.out.println("Listing Comments...");
        java.util.List lCommentsList = com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Comments").setMaxResults(ROW_COUNT).list();
        Comments[] lcomxeocamCommentss = (Comments[]) lCommentsList.toArray(new Comments[lCommentsList.size()]);
        int length = Math.min(lcomxeocamCommentss.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(lcomxeocamCommentss[i]);
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Task...");
        java.util.List lTaskList = com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Task").setMaxResults(ROW_COUNT).list();
        Task[] lcomxeocamTasks = (Task[]) lTaskList.toArray(new Task[lTaskList.size()]);
        length = Math.min(lcomxeocamTasks.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(lcomxeocamTasks[i]);
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Users...");
        java.util.List lUsersList = com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Users").setMaxResults(ROW_COUNT).list();
        Users[] lcomxeocamUserss = (Users[]) lUsersList.toArray(new Users[lUsersList.size()]);
        length = Math.min(lcomxeocamUserss.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(lcomxeocamUserss[i]);
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Role...");
        java.util.List lRoleList = com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.Role").setMaxResults(ROW_COUNT).list();
        Role[] lcomxeocamRoles = (Role[]) lRoleList.toArray(new Role[lRoleList.size()]);
        length = Math.min(lcomxeocamRoles.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(lcomxeocamRoles[i]);
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing UserRole...");
        java.util.List lUserRoleList = com.xeocam.TaskmanagementPersistentManager.instance().getSession().createQuery("From com.xeocam.model.UserRole").setMaxResults(ROW_COUNT).list();
        UserRole[] lcomxeocamUserRoles = (UserRole[]) lUserRoleList.toArray(new UserRole[lUserRoleList.size()]);
        length = Math.min(lcomxeocamUserRoles.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(lcomxeocamUserRoles[i]);
        }
        System.out.println(length + " record(s) retrieved.");

    }

    public void listByCriteria() throws PersistentException {
        System.out.println("Listing Comments by Criteria...");
        CommentsCriteria lcomxeocamCommentsCriteria = new CommentsCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamCommentsCriteria.id.eq();
        lcomxeocamCommentsCriteria.setMaxResults(ROW_COUNT);
        Comments[] comxeocamCommentses = lcomxeocamCommentsCriteria.listComments();
        int length = comxeocamCommentses == null ? 0 : Math.min(comxeocamCommentses.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(comxeocamCommentses[i]);
        }
        System.out.println(length + " Comments record(s) retrieved.");

        System.out.println("Listing Task by Criteria...");
        TaskCriteria lcomxeocamTaskCriteria = new TaskCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamTaskCriteria.id.eq();
        lcomxeocamTaskCriteria.setMaxResults(ROW_COUNT);
        Task[] comxeocamTasks = lcomxeocamTaskCriteria.listTask();
        length = comxeocamTasks == null ? 0 : Math.min(comxeocamTasks.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(comxeocamTasks[i]);
        }
        System.out.println(length + " Task record(s) retrieved.");

        System.out.println("Listing Users by Criteria...");
        UsersCriteria lcomxeocamUsersCriteria = new UsersCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamUsersCriteria.id.eq();
        lcomxeocamUsersCriteria.setMaxResults(ROW_COUNT);
        Users[] comxeocamUserses = lcomxeocamUsersCriteria.listUsers();
        length = comxeocamUserses == null ? 0 : Math.min(comxeocamUserses.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(comxeocamUserses[i]);
        }
        System.out.println(length + " Users record(s) retrieved.");

        System.out.println("Listing Role by Criteria...");
        RoleCriteria lcomxeocamRoleCriteria = new RoleCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamRoleCriteria.id.eq();
        lcomxeocamRoleCriteria.setMaxResults(ROW_COUNT);
        Role[] comxeocamRoles = lcomxeocamRoleCriteria.listRole();
        length = comxeocamRoles == null ? 0 : Math.min(comxeocamRoles.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(comxeocamRoles[i]);
        }
        System.out.println(length + " Role record(s) retrieved.");

        System.out.println("Listing UserRole by Criteria...");
        UserRoleCriteria lcomxeocamUserRoleCriteria = new UserRoleCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lcomxeocamUserRoleCriteria.id.eq();
        lcomxeocamUserRoleCriteria.setMaxResults(ROW_COUNT);
        UserRole[] comxeocamUserRoles = lcomxeocamUserRoleCriteria.listUserRole();
        length = comxeocamUserRoles == null ? 0 : Math.min(comxeocamUserRoles.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(comxeocamUserRoles[i]);
        }
        System.out.println(length + " UserRole record(s) retrieved.");

    }

    public static void main(String[] args) {
        try {
            ListTaskmanagementData listTaskmanagementData = new ListTaskmanagementData();
            try {
                listTaskmanagementData.listTestData();
                //listTaskmanagementData.listByCriteria();
            } finally {
                com.xeocam.TaskmanagementPersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
