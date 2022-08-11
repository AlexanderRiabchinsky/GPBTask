package main.controller;

import main.api.request.RegListRequest;
import main.api.response.RegResponse;
import main.servise.ApiListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {
    private final ApiListService listService;

    public ListController(ApiListService listService) {
        this.listService = listService;
    }
    @PostMapping("/api/list")
    public ResponseEntity<RegResponse> newList(@RequestBody RegListRequest regListRequest) {
        return ResponseEntity.ok(listService.getRegListResponse(regListRequest));
    }
}
