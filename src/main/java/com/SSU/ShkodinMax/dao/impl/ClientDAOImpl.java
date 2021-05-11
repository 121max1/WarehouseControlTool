package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.ClientDAO;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

public class ClientDAOImpl  implements ClientDAO {

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void save(Client client) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(client);

        }

    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }
}
