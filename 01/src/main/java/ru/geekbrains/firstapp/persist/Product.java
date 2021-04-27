package ru.geekbrains.firstapp.persist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Product {
    Long id;
    String title;
    BigDecimal cost;
}
