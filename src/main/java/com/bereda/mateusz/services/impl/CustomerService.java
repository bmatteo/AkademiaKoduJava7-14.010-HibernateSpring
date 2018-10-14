package com.bereda.mateusz.services.impl;

import com.bereda.mateusz.model.Customer;
import com.bereda.mateusz.services.ICustomerService;
import com.bereda.mateusz.services.IHibernateSessionFactoryService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerService implements ICustomerService {

    private IHibernateSessionFactoryService sessionFactoryService;

    public CustomerService(IHibernateSessionFactoryService sessionFactoryService) {
        this.sessionFactoryService = sessionFactoryService;
    }


    @Override
    public void saveCustomer(Customer customer) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", id));
        Customer customer = (Customer) criteria.uniqueResult();

        transaction.commit();
        session.close();
        return customer;
    }
}
