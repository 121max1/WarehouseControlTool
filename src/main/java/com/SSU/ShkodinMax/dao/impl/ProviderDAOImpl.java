package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ProviderDAO;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProviderDAOImpl implements ProviderDAO {
    @Override
    public Provider findById(int id) throws Exception {
        Provider provider = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            provider = session.get(Provider.class, id);
            if(provider != null)
            {
                return provider;
            }else{
                throw new Exception("Provider object doesn't exist.");
            }

        }catch (HibernateException e){
            throw new Exception("Unable to find Provider object");
        }
    }

    @Override
    public void save(Provider provider) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(provider);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Provider object.");
        }
    }

    @Override
    public void update(Provider provider) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(provider);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to update Provider object.");
        }
    }

    @Override
    public void delete(Provider provider) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(provider);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to delete Provider object.");
        }
    }
}
