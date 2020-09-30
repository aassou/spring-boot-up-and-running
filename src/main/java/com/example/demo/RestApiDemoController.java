package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RestApiDemoController {
    private List<Tea> teas = new ArrayList<>();

    public RestApiDemoController()  {
        teas.addAll(List.of(
            new Tea("Earl Grey"),
            new Tea("Assana"),
            new Tea("English Breakfast"),
            new Tea("Jasmin")
        ));
    }

    @GetMapping("/teas")
    Iterable<Tea> getTeas() {
        return teas;
    }

    @GetMapping("/teas/{id}")
    Optional<Tea> getTeaById(@PathVariable String id) {
        for (Tea t : teas) {
            if (t.getId().equals(id)) {
                return Optional.of(t);
            }
        } 
        return Optional.empty();
    }

    @PostMapping("/teas")
    Tea postTea(@RequestBody Tea tea) {
        teas.add(tea);
        return tea; 
    }
}