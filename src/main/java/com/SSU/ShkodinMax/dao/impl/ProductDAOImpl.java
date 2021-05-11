package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ProductDAO;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public Product findById(int id) throws Exception {
        Product product = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            product = session.get(Product.class, id);
            if(product != null)
            {
                return product;
            }else{
                throw new Exception("Product object doesn't exist.");
            }

        }catch (HibernateException e){
            throw new Exception("Unable to find Product object");
        }
    }

    @Override
    public void save(Product product) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Pruduct object.");
        }
    }

    @Override
    public void update(Product product) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to update Product object.");
        }
    }

    @Override
    public void delete(Product product) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to delete Product object.");
        }
    }
}
