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

import lombok.RequiredArgsConstructor;

import com.example.demo.repository.*;
import com.example.demo.domain.*;

@RestController
@RequestMapping("/fans")
@RequiredArgsConstructor
public class RestApiFanController {
    private final FanRepository fanRepository;

    @GetMapping
    Iterable<Fan> getFans() {
        return fanRepository.findAll();
    }

    @GetMapping("{/id}")
    Optional<Fan> getFanById(@PathVariable Long id) {
        return fanRepository.findById(id);
    }

    @PostMapping
    public Fan postFan(@RequestBody Fan fan) {
        System.out.println("fan " + fan.getPassword() + " - " + fan.getEmail() + " - " + fan.getId());
        return fanRepository.save(fan);
    }

    @PutMapping("{/id}")
    ResponseEntity<Fan> putFan(@PathVariable Long id, @RequestBody Fan fan) {
        return (fanRepository.existsById(id)) 
            ? new ResponseEntity<>(fanRepository.save(fan), HttpStatus.OK)
            : new ResponseEntity<>(fanRepository.save(fan), HttpStatus.CREATED);
    }

    @DeleteMapping("{/id}")
    void deleteFan(@PathVariable Long id) {
        fanRepository.deleteById(id);
    }
}
