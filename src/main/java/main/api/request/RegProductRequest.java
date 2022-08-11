package main.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegProductRequest {
    private String name;
    private String description;
    private long kcal;
}
