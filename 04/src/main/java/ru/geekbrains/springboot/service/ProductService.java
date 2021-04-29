package ru.geekbrains.springboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.springboot.dto.ProductDto;
import ru.geekbrains.springboot.repository.ProductRepository;
import ru.geekbrains.springboot.util.ConverterUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        log.debug("findall");
        return productRepository.findAll().stream()
                .map(ConverterUtil::productToDto)
                .collect(Collectors.toList());
    }

    public Long save(ProductDto product) {
        if (product.getId() == null) {
            return productRepository.create(ConverterUtil.dtoToProduct(product)).getId();
        }
        else {
            return productRepository.update(ConverterUtil.dtoToProduct(product)).getId();
        }
    }

    public ProductDto getById(Long id) {
        log.debug("find by id");
        ProductDto product = ConverterUtil.productToDto(productRepository.getById(id));
        log.debug("find by id: " + product.getTitle());
        return product;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
