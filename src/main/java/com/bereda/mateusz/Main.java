package com.bereda.mateusz;

import com.bereda.mateusz.model.Customer;
import com.bereda.mateusz.model.CustomerB2B;
import com.bereda.mateusz.services.ICustomerB2BService;
import com.bereda.mateusz.services.ICustomerService;
import com.bereda.mateusz.services.IHibernateSessionFactoryService;
import com.bereda.mateusz.services.impl.CustomerB2BService;
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

        ICustomerB2BService customerB2BService = new CustomerB2BService(hibernateSessionFactoryService);

        CustomerB2B customerB2B = new CustomerB2B();
        customerB2B.setCompanyName("Akademia Kodu");
        customerB2B.setNip("123123123");
        customerB2B.setRegon("34123412342134");
        customerB2B.setFax("12 1243243");

        customerB2BService.saveCustomer(customerB2B);

        CustomerB2B customerB2BFromDb = customerB2BService.getCustomerById(1);

        System.out.println(customerB2BFromDb);

        System.exit(0);
    }
}
