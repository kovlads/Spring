package ru.geekbrains.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.springmvc.dto.Product;
import ru.geekbrains.springmvc.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {
    private final ProductRepository productRepository;

    public void add(Product product) {
        log.debug("add:  " + product);
        if (product.getId() == null) {
            product.setId(productRepository.getNextId());
        }
        productRepository.add(product);
    }

    public List<Product> findAll() {
        log.debug("findall");
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        log.debug("find by id");
        Product product = productRepository.getById(id);
        log.debug("find by id: " + product.getTitle());
        return product;
    }
}
