package ru.geekbrains.springboot.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springboot.dto.ProductDto;
import ru.geekbrains.springboot.exception.ServiceException;
import ru.geekbrains.springboot.model.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> productList = new CopyOnWriteArrayList<>();
    private AtomicLong generator = new AtomicLong();

    @PostConstruct
    public void init() {
        productList.add(new Product(generator.incrementAndGet()
                ,"Книга"
                , new BigDecimal(15)
                , 1, false
        ));

    }

    public List<Product> findAll() {
//        return productList.stream()
//                .filter(it -> !it.getIsDeleted())
//                .collect(Collectors.toUnmodifiableList());
        return Collections.unmodifiableList(productList.stream()
                .filter(it -> !it.getIsDeleted()).collect(Collectors.toList()));
    }

    public Product create(Product product) {
        product.setId(generator.incrementAndGet());
        productList.add(product);
        return product;
    }

    public Product update(Product product) {
        if (product.getId() == null) {
            throw new ServiceException("can't update");
        }
        Product productInDb = productList.stream()
                .filter(it -> it.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        product.setVersion(productInDb.getVersion() + 1);
        productList.remove(productInDb);
        product.setIsDeleted(false);
        productList.add(product);
        return product;

    }

    public Product getById(Long id) {
        return productList.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .get();

    }

    public int deleteById(long id) {
        List<Product> toDelete = productList.stream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());
        toDelete.forEach(it -> it.setIsDeleted(true));
        return toDelete.size();
    }
}
