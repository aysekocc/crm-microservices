package com.aysekoc.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "product-service")
public interface ProductClient {
    @GetMapping("/api/v1/product")
    String get();

}
