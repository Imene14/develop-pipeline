package com.example.docker.demo.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> getRequests(@RequestParam(required = false) String status) {
        if (status != null) {
            return requestService.getRequestsByStatus(status);
        } else {
            return requestService.getAllRequests();
        }
    }
}
