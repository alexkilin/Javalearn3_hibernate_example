package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery( "CREATE TABLE IF NOT EXISTS Users (id BIGINT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL," +
                        " age TINYINT,PRIMARY KEY (id))"  ).executeUpdate();
        transaction.commit();
        session.close();
   }

    @Override
    public void dropUsersTable() {
        Session session = Util.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery( "DROP TABLE IF EXISTS Users"  ).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save (new User(name,lastName,age));
        transaction.commit();
        System.out.println("User c именем " + name + " добавлен в базу данных");
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User WHERE id =:userId");
        query.setParameter("userId",id ).executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userArrayList;
        Session session = Util.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        userArrayList =(List<User>) criteria.list();
        session.close();
        return userArrayList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
