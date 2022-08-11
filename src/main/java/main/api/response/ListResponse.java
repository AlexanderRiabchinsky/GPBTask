package main.api.response;

import lombok.Getter;
import lombok.Setter;
import main.model.Product;

import java.util.List;

@Getter
@Setter
public class ListResponse {
    private List<Product> products;
    private long sumOfKcals;
}
