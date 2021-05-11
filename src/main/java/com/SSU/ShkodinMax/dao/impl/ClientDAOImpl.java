package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ClientDAO;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClientDAOImpl  implements ClientDAO {

    @Override
    public Client findById(int id) throws Exception {
        Client client = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            client = session.get(Client.class, id);
            if(client != null)
            {
                return client;
            }else{
                throw new Exception("Client object doesn't exist.");
            }

        }
        catch(HibernateException e){
            throw new Exception("Client object doesn't exist.");
        }
    }

    @Override
    public void save(Client client) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e) {
            throw new Exception("Unable to find Client object.");
        }

    }

    @Override
    public void update(Client client) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            throw new Exception("Unable to update Client object.");
        }

    }

    @Override
    public void delete(Client client) throws Exception {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            throw new Exception("Unable to delete Client object.");
        }
    }

}
