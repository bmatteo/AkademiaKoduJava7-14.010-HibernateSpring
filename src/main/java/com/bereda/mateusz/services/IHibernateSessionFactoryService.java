package com.bereda.mateusz.services;

import org.hibernate.Session;

public interface IHibernateSessionFactoryService {
    Session getSession();
}
