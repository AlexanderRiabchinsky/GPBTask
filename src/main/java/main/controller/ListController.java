package main.controller;

import main.api.request.RegListRequest;
import main.api.response.ListResponse;
import main.api.response.ProductResponse;
import main.api.response.RegResponse;
import main.model.Product;
import main.repositories.ProductRepository;
import main.servise.ApiListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ListController {
    private final ApiListService listService;
    private final ProductRepository productRepository;

    public ListController(ApiListService listService, ProductRepository productRepository) {
        this.listService = listService;
        this.productRepository = productRepository;
    }
    @PostMapping("/api/list")
    public ResponseEntity<RegResponse> newList(@RequestBody RegListRequest regListRequest) {
        return ResponseEntity.ok(listService.getRegListResponse(regListRequest));
    }
    @PutMapping("/api/list/{id}")
    public ResponseEntity<RegResponse> addProduct(@PathVariable long listId,@PathVariable long productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else return ResponseEntity.ok(listService.addProductToList(listId,productId));
    }
    @GetMapping("/api/list/{id}")
    public ResponseEntity<ListResponse> listCurrent(@PathVariable long listId){
        return ResponseEntity.ok(listService.getCurrentList(listId));
    }
}
