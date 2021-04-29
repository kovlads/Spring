package ru.geekbrains.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springboot.dto.ProductDto;
import ru.geekbrains.springboot.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value="/{id}")
    public String showById(Model model, @PathVariable(value = "id") Long id) {
        ProductDto product = productService.getById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping
    public String addProduct(@ModelAttribute ProductDto product) {
        productService.save(product);
        return "redirect:/catalog";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/catalog";
    }
}