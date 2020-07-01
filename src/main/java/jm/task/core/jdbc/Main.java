package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Connection mySQLConnection = Util.getMySQLConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        User user1 = new User("Alex", "Sidorov", (byte) 5);
        User user2 = new User("Michael", "Ivanov", (byte) 25);
        User user3 = new User("Ivan", "Petrov", (byte) 35);
        User user4 = new User("Oleg", "Lee", (byte) 45);


//        userDaoJDBC.saveUser("Alex","Sidorov",(byte)5);
//        userDaoJDBC.saveUser("Michael","Ivanov",(byte) 25);
//        userDaoJDBC.saveUser("Ivan","Petrov",(byte) 35);

        userDaoJDBC.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDaoJDBC.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDaoJDBC.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDaoJDBC.saveUser(user4.getName(), user4.getLastName(), user4.getAge());


        List<User> userList = userDaoJDBC.getAllUsers();

        for (int i = 0; i < userList.size(); i++) {


            System.out.print(userList.get(i).toString());
            System.out.println();
        }




            userDaoJDBC.cleanUsersTable();

            userDaoJDBC.dropUsersTable();


        }

}