package jm.task.core.jdbc.util;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.service.ServiceRegistryBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {


        public static Connection getMySQLConnection() throws SQLException,
                ClassNotFoundException {
            String hostName = "localhost";

            String dbName = "example2";
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



        

}
