package main.servise;

import lombok.AllArgsConstructor;
import main.api.request.RegListRequest;
import main.api.response.ListResponse;
import main.api.response.ProductOfList;
import main.api.response.RegResponse;
import main.model.List;
import main.model.Product;
import main.repositories.ListRepository;
import main.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ApiListService {
    private final ListRepository listRepository;
    private final ProductRepository productRepository;

    public RegResponse getRegListResponse(RegListRequest request) {
        RegResponse response = new RegResponse();
        List list = new List();
        list.setName(request.getName());
        listRepository.save(list);
        response.setResult(true);
        return response;
    }

    public RegResponse addProductToList(long listId, long productId) {
        RegResponse response = new RegResponse();
        Product product = productRepository.findById(productId).get();
        List list = listRepository.findById(listId).get();
        java.util.List<Product> listOfProducts = list.getProducts();
        boolean check = true;
        for (Product aProduct : listOfProducts) {
            if (aProduct.getId() == productId) {
                check = false;
                break;
            }
        }
        if (check) {
            listOfProducts.add(product);
            list.setProducts(listOfProducts);
            listRepository.save(list);
            response.setResult(true);
        } else {
            response.setResult(false);
        }
        return response;
    }

    public ListResponse getCurrentList(long listId) {
        ListResponse response = new ListResponse();
        java.util.List<Long> prodIdList = listRepository.getIdProdList(listId);
        java.util.List<ProductOfList> productsOfList = new ArrayList<>();
        for(long id:prodIdList){ProductOfList prodDto = new ProductOfList();
            prodDto.setId(id);
            prodDto.setName(productRepository.findById(id).get().getName());
            prodDto.setDescription(productRepository.findById(id).get().getDescription());
            prodDto.setKcal(productRepository.findById(id).get().getKcal());
            productsOfList.add(prodDto);}
        long sumKcal = 0;
        for (ProductOfList aProduct : productsOfList) {
            sumKcal += aProduct.getKcal();
        }
        response.setProducts(productsOfList);
        response.setSumOfKcals(sumKcal);
        return response;
    }
}
