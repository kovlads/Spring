package ru.geekbrains.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = "ru.geekbrains.service")
public class AppConfig {

    @Bean("cart")
    public Cart cart() {
        ProductRepository products = new ProductRepositoryImpl();
        products.add(new Product(null,"book",new BigDecimal(15)));
        products.add(new Product(null,"pen",new BigDecimal(15)));
        products.add(new Product(null,"car",new BigDecimal(20000)));
        products.add(new Product(null,"flat",new BigDecimal(75000)));
        products.add(new Product(null,"air",new BigDecimal(1500000)));

        return new CartImpl(products);
    }
}
