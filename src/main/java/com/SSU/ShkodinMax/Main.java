package com.SSU.ShkodinMax;

import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }
}
