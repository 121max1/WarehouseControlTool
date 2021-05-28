package com.SSU.ShkodinMax.repository.impl;

import com.SSU.ShkodinMax.repository.ProductDAO;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private  SessionFactory sessionFactory;

    public ProductDAOImpl(){
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Session session = sessionFactory.openSession()) {
            product = session.get(Product.class, id);
            return product;

        }
    }

    @Override
    public void save(Product product){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Product product){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
    @Override
    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> rootEntry = cq.from(Product.class);
            CriteriaQuery<Product> all = cq.select(rootEntry);

            TypedQuery<Product> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
