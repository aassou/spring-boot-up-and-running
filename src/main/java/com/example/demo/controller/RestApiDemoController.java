package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/teas")
class RestApiDemoController {
    private final TeaRepository teaRepository;

    public RestApiDemoController(TeaRepository teaRepository)  {
        this.teaRepository = teaRepository;
    }

    @GetMapping
    Iterable<Tea> getTeas() {
        return teaRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Tea> getTeaById(@PathVariable Long id) {
        return teaRepository.findById(id);
    }

    @PostMapping
    Tea postTea(@RequestBody Tea tea) {
        return teaRepository.save(tea);
    }

    @PutMapping("/{id}")
    ResponseEntity<Tea> putTea(@PathVariable Long id, @RequestBody Tea tea) {
        return (teaRepository.existsById(id)) 
            ? new ResponseEntity<>(teaRepository.save(tea), HttpStatus.OK)
            : new ResponseEntity<>(teaRepository.save(tea), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteTea(@PathVariable Long id) {
        teaRepository.deleteById(id);
    }
}