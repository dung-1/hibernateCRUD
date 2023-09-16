package com.springmvc.hibernatedemo.services;

import java.util.List;

import com.springmvc.hibernatedemo.entity.Customer;



public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

}
