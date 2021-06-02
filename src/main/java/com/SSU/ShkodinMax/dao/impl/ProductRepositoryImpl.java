package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ProductRepository;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private  SessionFactory sessionFactory;

    public ProductRepositoryImpl(){
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Product findById(int id) throws Exception {
        Product product = null;
        try (Session session = sessionFactory.openSession()) {
            product = session.get(Product.class, id);
            if(product == null){
                throw new Exception(String.format("Product with specified %s doesn't exist", id));
            }
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
