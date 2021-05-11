package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.StaffDAO;
import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public Staff findById(int id) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Staff staff = session.get(Staff.class, id);
            if(staff != null)
            {
                return staff;
            }else{
                throw new Exception("Staff object doesn't exist.");
            }

        }catch (HibernateException e){
            throw new Exception("Unable to find Staff object");
        }
    }

    @Override
    public void save(Staff staff) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(staff);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to save Staff object.");
        }
    }

    @Override
    public void update(Staff staff) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(staff);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to update Staff object.");
        }
    }

    @Override
    public void delete(Staff staff) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(staff);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to delete Staff object.");
        }
    }
}
