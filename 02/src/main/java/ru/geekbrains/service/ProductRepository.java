package ru.geekbrains.service;

import java.util.List;

public interface ProductRepository {
    public Product findById(long id);
    public List<Product> findAll();
    public void deleteById(Long id);
    public void add(Product product);
}
