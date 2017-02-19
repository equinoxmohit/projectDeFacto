package com.projectdfacto.dao.daoImpl;

import com.projectdfacto.dao.ProductDao;
import com.projectdfacto.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by equinoxmohit on 2/18/17.
 */
@Repository(value = "productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void update(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public List<Product> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product");
        List<Product> products=query.list();
        session.flush();
        return products;
    }

    @Override
    public Product getById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Product product=(Product) session.get(Product.class,id);
        session.flush();
        return product;
    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }
}
