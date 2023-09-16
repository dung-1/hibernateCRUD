package com.springmvc.hibernatedemo.repository;

import java.util.List;

import com.springmvc.hibernatedemo.entity.Customer;
import com.springmvc.hibernatedemo.entity.Products;



public interface ProductRepository {

    public List < Products > getProducts();

    public void saveProducts(Products theProducts);

    public Products getProducts(int theId);

    public void deleteProducts(int theId);
}
