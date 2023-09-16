package com.springmvc.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.hibernatedemo.entity.Products;
import com.springmvc.hibernatedemo.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProducts(Model theModel) {
        List<Products> theProducts = productService.getProducts();
        theModel.addAttribute("products", theProducts);
        return "list-products";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Products theProducts = new Products();
        theModel.addAttribute("products", theProducts);
        return "products-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("products") Products theProducts) {
        productService.saveProducts(theProducts);
        return "redirect:/products/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
        Products theProducts = productService.getProducts(theId);
        theModel.addAttribute("products", theProducts);
        return "products-form";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int theId) {
        productService.deleteProducts(theId);
        return "redirect:/products/list";
    }
}
