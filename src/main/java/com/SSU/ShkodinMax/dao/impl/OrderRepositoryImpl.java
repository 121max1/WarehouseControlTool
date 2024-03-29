package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.OrderRepository;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private  SessionFactory sessionFactory;

    public OrderRepositoryImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Order findById(int id) throws Exception {
        Order order = null;
        try (Session session = sessionFactory.openSession()) {
            order = session.get(Order.class, id);
            if(order == null){
                throw new Exception(String.format("Order with specified %s doesn't exist", id));
            }
            return order;
        }
    }

    @Override
    public void save(Order order){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Order order){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Order order){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();

        }
    }
    @Override
    public List<Order> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> cq = cb.createQuery(Order.class);
            Root<Order> rootEntry = cq.from(Order.class);
            CriteriaQuery<Order> all = cq.select(rootEntry);

            TypedQuery<Order> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
