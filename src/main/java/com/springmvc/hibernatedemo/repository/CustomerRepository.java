package com.springmvc.hibernatedemo.repository;

import java.util.List;

import com.springmvc.hibernatedemo.entity.Customer;



public interface CustomerRepository {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
