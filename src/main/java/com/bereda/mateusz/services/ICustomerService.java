package com.bereda.mateusz.services;

import com.bereda.mateusz.model.Customer;

public interface ICustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
}
