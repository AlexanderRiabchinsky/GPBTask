package main.servise;

import lombok.AllArgsConstructor;
import main.api.request.RegProductRequest;
import main.api.response.RegResponse;
import main.model.Product;
import main.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
}
