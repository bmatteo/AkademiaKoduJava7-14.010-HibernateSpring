package com.bereda.mateusz;

import com.bereda.mateusz.model.Customer;
import com.bereda.mateusz.services.ICustomerService;
import com.bereda.mateusz.services.IHibernateSessionFactoryService;
import com.bereda.mateusz.services.impl.CustomerService;
import com.bereda.mateusz.services.impl.HibernateSessionFactoryService;

public class Main {
    public static void main(String[] args) {
        IHibernateSessionFactoryService hibernateSessionFactoryService = new HibernateSessionFactoryService();
        ICustomerService customerService = new CustomerService(hibernateSessionFactoryService);

        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Kowalski");
        customer.setPhone("123123123");

        customerService.saveCustomer(customer);

        Customer customerFromDb = customerService.getCustomerById(1);
        System.out.println(customerFromDb);
    }
}
