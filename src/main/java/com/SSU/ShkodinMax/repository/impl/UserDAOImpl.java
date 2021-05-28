package com.SSU.ShkodinMax.repository.impl;

import com.SSU.ShkodinMax.repository.UserDAO;
import com.SSU.ShkodinMax.model.User;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private   SessionFactory sessionFactory;

    public UserDAOImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public User findByLogin(String login){
        try (Session session = sessionFactory.openSession()) {
            List<User> users = session.createCriteria(User.class).
                    add(Restrictions.eq("login", login)).list();
            if (!users.isEmpty()) {
                return users.iterator().next();
            } else {
                return null;
            }

        }
    }
}
