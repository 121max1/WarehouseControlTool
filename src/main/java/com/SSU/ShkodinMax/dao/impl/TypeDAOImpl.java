package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.TypeDAO;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TypeDAOImpl implements TypeDAO {

    @Override
    public Type findById(int id) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Type type = session.get(Type.class, id);
            if(type != null)
            {
                return type;
            }else{
                throw new Exception("Type object doesn't exist.");
            }

        }catch (HibernateException e){
            throw new Exception("Unable to find Type object");
        }
    }

    @Override
    public void save(Type type) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Type object.");
        }
    }

    @Override
    public void update(Type type) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to update Type object.");
        }
    }

    @Override
    public void delete(Type type) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to delete Type object.");
        }
    }
}
