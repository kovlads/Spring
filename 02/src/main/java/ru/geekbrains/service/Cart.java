package ru.geekbrains.service;

import java.util.List;

public interface Cart {
    void add(long id);

    void delete(long id);

     List<Product> getAllProducts();
}
