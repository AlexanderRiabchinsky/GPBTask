package main.controller;

import main.api.request.RegProductRequest;
import main.api.response.RegResponse;
import main.servise.ApiProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ApiProductService productService;

    public ProductController(ApiProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/product")
    public ResponseEntity<RegResponse> newProduct(@RequestBody RegProductRequest regProductRequest) {
        return ResponseEntity.ok(productService.getRegProductResponse(regProductRequest));
    }
}