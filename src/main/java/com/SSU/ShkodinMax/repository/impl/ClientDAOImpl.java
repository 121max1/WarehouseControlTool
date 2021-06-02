package com.SSU.ShkodinMax.repository.impl;

import com.SSU.ShkodinMax.repository.ClientDAO;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientDAOImpl  implements ClientDAO {

    private  SessionFactory sessionFactory;

    public ClientDAOImpl(){
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }
    @Override
    public Client findById(int id) throws Exception {
        Client client = null;
        try (Session session = sessionFactory.openSession()) {
            client = session.get(Client.class, id);
            if (client == null){
                throw new Exception(String.format("Client with specified %s doesn't exist", id));
            }
            return client;
        }
    }

    @Override
    public void save(Client client){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }


    }

    @Override
    public void update(Client client){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Client client){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Client> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cq = cb.createQuery(Client.class);
            Root<Client> rootEntry = cq.from(Client.class);
            CriteriaQuery<Client> all = cq.select(rootEntry);

            TypedQuery<Client> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }


}
