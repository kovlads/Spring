package ru.geekbrains.springmvc.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springmvc.dto.Product;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class ProductRepository {
    private final static List<Product> database = new CopyOnWriteArrayList<>();
    private static AtomicLong id = new AtomicLong();

    static {
        database.add(new Product(getNextId(), "Книга", new BigDecimal(15)));
    }

    public static Long getNextId() {
        return id.incrementAndGet();
    }

    public void add(Product product) {
        database.add(product);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(database);
    }

    public Product getById(Long id) {
        return database.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .get();

    }

}
