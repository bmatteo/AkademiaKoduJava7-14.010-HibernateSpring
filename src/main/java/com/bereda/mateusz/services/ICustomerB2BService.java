package com.bereda.mateusz.services;

import com.bereda.mateusz.model.CustomerB2B;

public interface ICustomerB2BService {
    void saveCustomer(CustomerB2B customer);
    CustomerB2B getCustomerById(int id);
}
