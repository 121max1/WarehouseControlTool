package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ProviderRepository;
import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProviderRepositoryImpl implements ProviderRepository {
    private  SessionFactory sessionFactory;

    public ProviderRepositoryImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Provider findById(int id) throws Exception {
        Provider provider = null;
        try (Session session = sessionFactory.openSession()) {
            provider = session.get(Provider.class, id);
            if(provider == null){
                throw new Exception(String.format("Provider with specified %s doesn't exist", id));
            }
            return provider;

        }
    }

    @Override
    public void save(Provider provider){
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(provider);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(Provider provider){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(provider);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Provider provider) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(provider);
            session.getTransaction().commit();
        }
    }
    @Override
    public List<Provider> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Provider> cq = cb.createQuery(Provider.class);
            Root<Provider> rootEntry = cq.from(Provider.class);
            CriteriaQuery<Provider> all = cq.select(rootEntry);

            TypedQuery<Provider> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
