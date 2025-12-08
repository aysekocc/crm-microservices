package com.aysekoc.cart_service.controller;

import com.aysekoc.cart_service.entity.Cart;
import com.aysekoc.cart_service.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public Cart get(@RequestParam String name) {

        return this.cartRepository.findByCustomerFullName(name).orElseThrow();
    }

    @GetMapping("/price")
    public List<Cart> getByPrice(@RequestParam float totalPrice) {
        return this.cartRepository.findByTotalPriceGreaterThan(totalPrice);
    }

    @PostMapping
    public void add(@RequestBody Cart cart) {
        this.cartRepository.insert(cart);
    }
}
