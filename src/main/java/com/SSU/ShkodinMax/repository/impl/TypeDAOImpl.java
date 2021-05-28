package com.SSU.ShkodinMax.repository.impl;

import com.SSU.ShkodinMax.repository.TypeDAO;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {
    private  SessionFactory sessionFactory;

    public TypeDAOImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Type findById(int id){
        try (Session session = sessionFactory.openSession()) {
            Type type = session.get(Type.class, id);
            return type;

        }
    }

    @Override
    public void save(Type type){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();

        }
    }

    @Override
    public void update(Type type){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Type type)  {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Type> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Type> cq = cb.createQuery(Type.class);
            Root<Type> rootEntry = cq.from(Type.class);
            CriteriaQuery<Type> all = cq.select(rootEntry);

            TypedQuery<Type> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
