package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.OrderedDAO;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class OrderedDAOImpl implements OrderedDAO {
    @Override
    public Ordered findByIdProduct (int id) throws Exception {
        Ordered ordered = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            ordered = session.get(Ordered.class, id);
            if(ordered != null)
            {
                return ordered;
            }else{
                throw new Exception("Ordered object doesn't exist.");
            }

        }catch (HibernateException e){
            throw new Exception("Unable to find Ordered object");
        }
    }

    @Override
    public void save(Ordered ordered) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(ordered);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Ordered object.");
        }
    }


    @Override
    public void update(Ordered ordered) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(ordered);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to update Ordered object.");
        }
    }

    @Override
    public void delete(Ordered ordered) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(ordered);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to delete Ordered object.");
        }
    }
}
