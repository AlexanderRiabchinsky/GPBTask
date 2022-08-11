package main.servise;

import lombok.AllArgsConstructor;
import main.api.request.RegProductRequest;
import main.api.response.ProductResponse;
import main.api.response.RegResponse;
import main.model.Product;
import main.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApiProductService {
    private final ProductRepository productRepository;

public RegResponse getRegProductResponse(RegProductRequest regProductRequest){
    RegResponse response = new RegResponse();
    Product product = new Product();
    product.setName(regProductRequest.getName());
    product.setDescription(regProductRequest.getDescription());
    product.setKcal(regProductRequest.getKcal());
    productRepository.save(product);
    response.setResult(true);
    return response;
}
public ProductResponse getCurrentProducts(){
    ProductResponse response = new ProductResponse();
    List<Product> allProducts = productRepository.findAll();
    List<Product> dTOlist = new ArrayList<>();
    for (Product aProduct: allProducts){
        Product dTOProduct = new Product();
        dTOProduct.setId(aProduct.getId());
        dTOProduct.setName(aProduct.getName());
        dTOProduct.setDescription(aProduct.getDescription());
        dTOProduct.setKcal(aProduct.getKcal());
        dTOlist.add(dTOProduct);
    }
    response.setProducts(dTOlist);
    return response;
}
}
