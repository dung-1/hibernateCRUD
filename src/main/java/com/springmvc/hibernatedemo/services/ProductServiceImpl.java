package com.springmvc.hibernatedemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.hibernatedemo.entity.Products;
import com.springmvc.hibernatedemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productsRepository;

    @Override
    @Transactional
    public List<Products> getProducts() {
        return productsRepository.getProducts();
    }

    @Override
    @Transactional
    public void saveProducts(Products product) {
        productsRepository.saveProducts(product);
    }

    @Override
    @Transactional
    public Products getProducts(int id) {
        return productsRepository.getProducts(id);
    }
    @Override
    @Transactional
    public void deleteProducts(int id) {
        productsRepository.deleteProducts(id);
    }

}
