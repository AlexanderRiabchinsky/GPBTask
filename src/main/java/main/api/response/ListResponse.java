package main.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse {
    private List<ProductOfList> products;
    private long sumOfKcals;
}
