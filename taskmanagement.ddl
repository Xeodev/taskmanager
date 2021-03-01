CREATE TABLE comments
(
    id      int(11)      NOT NULL AUTO_INCREMENT,
    usersid int(11)      NOT NULL,
    taskid  int(11)      NOT NULL,
    comment varchar(500) NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) type=InnoDB;
CREATE TABLE task
(
    id         int(11)       NOT NULL AUTO_INCREMENT,
    usersid    int(11)       NOT NULL,
    assignedTo int(11)       NOT NULL,
    title      varchar(45)   NOT NULL,
    detail     varchar(2000) NOT NULL,
    status     varchar(45)   NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) type=InnoDB;
CREATE TABLE users
(
    id        int(11)      NOT NULL AUTO_INCREMENT,
    userName  varchar(45)  NOT NULL,
    password  varchar(300) NOT NULL,
    firstName varchar(45)  NOT NULL,
    lastName  varchar(45)  NOT NULL,
    enabled   bit(4)       NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) type=InnoDB;
CREATE TABLE role
(
    id   int(11)     NOT NULL AUTO_INCREMENT,
    role varchar(45) NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) type=InnoDB;
CREATE TABLE userRole
(
    id      int(11) NOT NULL AUTO_INCREMENT,
    usersid int(11) NOT NULL,
    roleid  int(11) NOT NULL,
    PRIMARY KEY (id)
) type=InnoDB;
ALTER TABLE comments
    ADD CONSTRAINT FKcomments947971 FOREIGN KEY (usersid) REFERENCES users (id);
ALTER TABLE userRole
    ADD CONSTRAINT FKuserRole66183 FOREIGN KEY (usersid) REFERENCES users (id);
ALTER TABLE userRole
    ADD CONSTRAINT FKuserRole441121 FOREIGN KEY (roleid) REFERENCES role (id);
ALTER TABLE task
    ADD CONSTRAINT FKtask979092 FOREIGN KEY (usersid) REFERENCES users (id);
ALTER TABLE comments
    ADD CONSTRAINT FKcomments733203 FOREIGN KEY (taskid) REFERENCES task (id);
