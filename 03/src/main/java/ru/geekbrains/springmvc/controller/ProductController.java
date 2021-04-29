package ru.geekbrains.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import ru.geekbrains.springmvc.dto.Product;
import ru.geekbrains.springmvc.service.ProductService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {
    private final ProductService productService;


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String showById(Model model, @PathVariable(value = "id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.add(product);
        return "product";
    }

    @PostMapping("async")
    public DeferredResult<Product> getProducts() {
        DeferredResult<Product> result = new DeferredResult<>();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                Thread.sleep(10000);
                result.setResult(new Product());
            } catch (InterruptedException e) {
                e.printStackTrace();
                result.setErrorResult("");
            }

        });
        return result;
    }
}
