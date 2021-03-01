
package com.xeocam.ormsamples;

import org.orm.*;

public class CreateTaskmanagementDatabaseSchema {
    public static void main(String[] args) {
        try {
            ORMDatabaseInitiator.createSchema(com.xeocam.TaskmanagementPersistentManager.instance());
            com.xeocam.TaskmanagementPersistentManager.instance().disposePersistentManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
