package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();


        userServiceImpl.saveUser("Alex", "Sidorov", (byte) 5);
        userServiceImpl.saveUser("Michael", "Ivanov", (byte) 25);
        userServiceImpl.saveUser("Ivan", "Petrov", (byte) 35);
        userServiceImpl.saveUser("Oleg", "Lee", (byte) 45);


        List<User> userList = userServiceImpl.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.print(userList.get(i).toString());
            System.out.println();
        }

        userServiceImpl.cleanUsersTable();

        userServiceImpl.dropUsersTable();

        userServiceImpl.userDao.sessionFactory.close();

    }

}