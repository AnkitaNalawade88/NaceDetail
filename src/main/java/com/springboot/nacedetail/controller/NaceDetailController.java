package com.springboot.nacedetail.controller;

import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.repository.NaceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nace")
public class NaceDetailController {
    @Autowired
    private NaceDetailsRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addNaceDetails(@RequestBody NaceDetail naceDetail) {
        repository.save(naceDetail);
        return ResponseEntity.ok("NACE details added successfully");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<NaceDetail> getNaceDetails(@PathVariable Long code) {
        Optional<NaceDetail> naceDetail = repository.findByCode(code);
        return naceDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
