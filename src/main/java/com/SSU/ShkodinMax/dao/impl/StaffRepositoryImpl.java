package com.SSU.ShkodinMax.dao.impl;

import com.SSU.ShkodinMax.dao.StaffRepository;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StaffRepositoryImpl implements StaffRepository {
    private  SessionFactory sessionFactory;

    public StaffRepositoryImpl() {
        this.sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    public Staff findById(int id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Staff staff = session.get(Staff.class, id);
            if(staff == null){
                throw new Exception(String.format("Staff with specified %s doesn't exist", id));
            }
            return staff;

        }
    }

    @Override
    public void save(Staff staff){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(staff);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Staff staff) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(staff);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Staff staff){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(staff);
            session.getTransaction().commit();
        }
    }
    @Override
    public List<Staff> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Staff> cq = cb.createQuery(Staff.class);
            Root<Staff> rootEntry = cq.from(Staff.class);
            CriteriaQuery<Staff> all = cq.select(rootEntry);

            TypedQuery<Staff> allQuery = session.createQuery(all);
            return allQuery.getResultList();

        }
    }
}
