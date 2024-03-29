package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.TypeRepository;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TypeRepositoryImpl implements TypeRepository {
    private  SessionFactory sessionFactory;

    public TypeRepositoryImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Type findById(int id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Type type = session.get(Type.class, id);
            if(type == null){
                throw new Exception(String.format("Type with specified %s doesn't exist", id));
            }
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
            session.update(type);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Type type)  {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(type);
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
