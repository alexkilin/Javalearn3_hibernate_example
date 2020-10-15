package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {
    public static SessionFactory sessionFactory;

    public static Connection getMySQLConnection() throws SQLException,
                ClassNotFoundException {
            String hostName = "localhost";
            String dbName = "example1";
            String userName = "root";
            String password = "forest";

            return getMySQLConnection(hostName, dbName, userName, password);
        }

        public static Connection getMySQLConnection(String hostName, String dbName,
                                                    String userName, String password) throws SQLException,
                ClassNotFoundException {

            // Class.forName("com.mysql.jdbc.Driver");

            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

            Connection conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        }


        public static SessionFactory getSessionFactory () {

             Configuration configuration = new org.hibernate.cfg.Configuration();

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localHost:3306/example2")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "forest")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.hbm2ddl.auto", "update");


//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                  .applySettings(configuration.getProperties());

            configuration.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            //ServiceRegistry serviceRegistry = builder.buildServiceRegistry; //все ли так???

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }










}
