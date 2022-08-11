package main.servise;

import lombok.AllArgsConstructor;
import main.api.request.RegListRequest;
import main.api.response.RegResponse;
import main.model.List;
import main.repositories.ListRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApiListService {
    private final ListRepository listRepository;

    public RegResponse getRegListResponse(RegListRequest request){
        RegResponse response = new RegResponse();
        List list = new List();
        list.setName(request.getName());
        listRepository.save(list);
        response.setResult(true);
        return response;
    }
}
