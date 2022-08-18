package main.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertListRequest {
    private long listId;
    private long productId;
}
