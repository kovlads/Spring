package ru.geekbrains.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springboot.dto.ProductDto;
import ru.geekbrains.springboot.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;

    @GetMapping
    @ModelAttribute("products")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

//    @PostMapping
//    public String create(@ModelAttribute ProductDto product) {
//        productService.save(product);
//        return "redirect:/catalog";
//
//    }


}
