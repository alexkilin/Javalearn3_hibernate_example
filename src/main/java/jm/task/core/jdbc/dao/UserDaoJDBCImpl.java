package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }



    public void createUsersTable() {

        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "CREATE TABLE IF NOT EXISTS Users (id BIGINT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL," +
                " age TINYINT,PRIMARY KEY (id))";


        try {
            myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void dropUsersTable() {
        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = " DROP TABLE IF EXISTS Users ";


        try {
            myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {


        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = " INSERT INTO Users (name, lastName, age) \n" +
    "VALUES ('"+ name + "','" + lastName +"'," + age + ");";

      //  System.out.println(sql);

        try {
            myStatement.executeUpdate(sql);

            System.out.println("User c именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {

        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM Users WHERE id = '"+ id + "'";


        try {
            myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<User> getAllUsers() {

        List<User> userArrayList = new ArrayList<>();

        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "Select id, name, lastName, age from Users";

        try {
            ResultSet rs = myStatement.executeQuery (sql);

            while (rs.next()) {

                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String LastName = rs.getString(3);
                byte age = rs.getByte(4);

                User currentUser = new User(name,LastName,age);
                currentUser.setId(id);

                userArrayList.add(currentUser);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userArrayList;
    }

    public void cleanUsersTable() {

        Statement myStatement = null;
        try {
            myStatement = Util.getMySQLConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = " DELETE FROM Users ";


        try {
            myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
