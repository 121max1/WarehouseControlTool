package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.OrderedRepository;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderedRepositoryImpl implements OrderedRepository {
    private  SessionFactory sessionFactory;

    public OrderedRepositoryImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Ordered findById (int id) throws Exception {
        Ordered ordered = null;
        try (Session session = sessionFactory.openSession()) {
            ordered = session.get(Ordered.class, id);
            if(ordered == null){
                throw new Exception(String.format("Ordered with specified %s doesn't exist", id));
            }
            return ordered;

        }
    }

    @Override
    public void save(Ordered ordered) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(ordered);
            session.getTransaction().commit();
        }
    }


    @Override
    public void update(Ordered ordered) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(ordered);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Ordered ordered) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(ordered);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Ordered> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Ordered> cq = cb.createQuery(Ordered.class);
            Root<Ordered> rootEntry = cq.from(Ordered.class);
            CriteriaQuery<Ordered> all = cq.select(rootEntry);

            TypedQuery<Ordered> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
