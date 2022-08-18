package main.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class ProductOfList {
    @Id
    private long id;
    private String name;
    private String description;
    private long kcal;
}
