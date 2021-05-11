package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.OrderDAO;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Order findById(int id) throws Exception {
        Order order = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            order = session.get(Order.class, id);
            if(order != null)
            {
                return order;
            }else{
                throw new Exception("Order object doesn't exist.");
            }

        }
        catch(HibernateException e){
            throw new Exception("Unable to find Order object");
        }
    }

    @Override
    public void save(Order order) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Order object.");
        }
    }

    @Override
    public void update(Order order) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Order object.");
        }
    }

    @Override
    public void delete(Order order) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Order object.");
        }
    }
}
