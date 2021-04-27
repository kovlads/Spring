package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Setter
public class CartImpl implements Cart{
    private Map<Long, Product> cartMap = new ConcurrentHashMap<>();
    private final ProductRepository products;

    @Override
    public void add(long id) {
        Product product = products.findById(id);
        cartMap.put(product.getId(), product);
    }

    @Override
    public void delete(long id) {
        cartMap.remove(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(cartMap.values());
    }
}
