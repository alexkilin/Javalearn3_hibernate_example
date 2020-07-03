package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Util.sessionFactory = Util.getSessionFactory();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();


        userDaoHibernate.saveUser("Alex", "Sidorov", (byte) 5);
        userDaoHibernate.saveUser("Michael", "Ivanov", (byte) 25);
        userDaoHibernate.saveUser("Ivan", "Petrov", (byte) 35);
        userDaoHibernate.saveUser("Oleg", "Lee", (byte) 45);


        List<User> userList = userDaoHibernate.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.print(userList.get(i).toString());
            System.out.println();
        }

    //    userDaoHibernate.removeUserById(1);

        userDaoHibernate.cleanUsersTable();

        userDaoHibernate.dropUsersTable();

        Util.sessionFactory.close();


    }

}