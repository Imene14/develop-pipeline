package com.example.docker.demo.request;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RequestRepo extends JpaRepository<Request, Long> {
    List<Request> findByStatus(String status);
}
