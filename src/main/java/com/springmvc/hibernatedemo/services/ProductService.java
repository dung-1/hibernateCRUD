package com.springmvc.hibernatedemo.services;

import java.util.List;

import com.springmvc.hibernatedemo.entity.Customer;
import com.springmvc.hibernatedemo.entity.Products;



public interface ProductService {

    public List < Products > getProducts();

    public void saveProducts(Products theProducts);

    public Products getProducts(int theId);

    public void deleteProducts(int theId);
}
