package com.aysekoc.cart_service.controller;

import com.aysekoc.cart_service.entity.Cart;
import com.aysekoc.cart_service.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private final CartRepository cartRepository;

    @GetMapping
    public Cart get(@RequestParam String name) {

        return this.cartRepository.findByCustomerFullName(name).orElseThrow();
    }

    @GetMapping("price")
    public List<Cart> getByPrice(@RequestParam float price) {
        return this.cartRepository.findByTotalPriceGreaterThan(price);
    }

    @PostMapping
    public void add(@RequestBody Cart cart) {
        this.cartRepository.save(cart);
    }
}
