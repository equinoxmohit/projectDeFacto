package com.projectdfacto.dao;

import com.projectdfacto.entity.Product;

import java.util.List;

/**
 * Created by equinoxmohit on 2/18/17.
 */
public interface ProductDao {

    void insert(Product product);

    void update(Product product);

    List<Product> getAll();

    Product getById(int id);

    void delete(int id);


}
