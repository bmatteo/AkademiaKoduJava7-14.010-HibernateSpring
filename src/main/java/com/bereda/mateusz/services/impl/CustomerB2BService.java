package com.bereda.mateusz.services.impl;

import com.bereda.mateusz.model.CustomerB2B;
import com.bereda.mateusz.services.ICustomerB2BService;
import com.bereda.mateusz.services.IHibernateSessionFactoryService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerB2BService implements ICustomerB2BService {

    IHibernateSessionFactoryService sessionFactoryService;

    public CustomerB2BService(IHibernateSessionFactoryService sessionFactoryService) {
        this.sessionFactoryService = sessionFactoryService;
    }

    @Override
    public void saveCustomer(CustomerB2B customer) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public CustomerB2B getCustomerById(int id) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerB2B> query = criteriaBuilder.createQuery(CustomerB2B.class);

        Root<CustomerB2B> root = query.from(CustomerB2B.class);

        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        Query<CustomerB2B> q = session.createQuery(query);
        CustomerB2B customerB2B = q.getSingleResult();

        transaction.commit();
        session.close();
        return customerB2B;
    }
}
