package ru.geekbrains.springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springmvc.dto.Product;
import ru.geekbrains.springmvc.service.ProductService;

import java.util.List;


@Controller
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;

    @GetMapping
    @ModelAttribute("products")
    public List<Product> showAll() {
        return productService.findAll();
    }

}
