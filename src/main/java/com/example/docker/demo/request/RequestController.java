package com.example.docker.demo.request;

import com.example.docker.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<Request> getRequests(@RequestParam(required = false) String status) {
        if (status != null) {
            return requestService.getRequestsByStatus(status);
        } else {
            return requestService.getAllRequests();
        }
    }

    private RequestRepo requestRepo;
    @GetMapping("/request/{id}")
    public ResponseEntity<Optional<Request>> getReq(@PathVariable Long id) {
        Optional<Request> req = requestRepo.findById(id);
        if (req.isPresent()) {
            return ResponseEntity.ok(req);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
