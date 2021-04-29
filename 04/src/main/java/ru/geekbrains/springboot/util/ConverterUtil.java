package ru.geekbrains.springboot.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.geekbrains.springboot.dto.ProductDto;
import ru.geekbrains.springboot.model.Product;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtil {
    public static Product dtoToProduct(ProductDto dto) {
        return new Product(dto.getId(), dto.getTitle(), dto.getCost(), 1, false);
    }

    public static ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
}
