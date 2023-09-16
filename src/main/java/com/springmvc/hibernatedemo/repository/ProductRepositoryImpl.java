package com.springmvc.hibernatedemo.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.hibernatedemo.entity.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getProducts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Products> cq = cb.createQuery(Products.class);
        Root<Products> root = cq.from(Products.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public void deleteProducts(int id) {
        Session session = sessionFactory.getCurrentSession();
        Products product = session.get(Products.class, id);
        if (product != null) {
            session.delete(product);
        }
    }

    @Override
    public void saveProducts(Products product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);

    }

	@Override
	public Products getProducts(int theId) {
		  Session currentSession = sessionFactory.getCurrentSession();
	        Products theProducts = currentSession.get(Products.class, theId);
	        return theProducts;
	}


}
