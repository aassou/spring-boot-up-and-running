package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;


import com.example.demo.domain.Project;
import com.example.demo.repository.ProjectRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectRepository projectRepository;

    @GetMapping
    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("{/id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }

    @PostMapping
    public Project postProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping
    public ResponseEntity<Project> putProject(@PathVariable Long id, @RequestBody Project project) {
        return (projectRepository.existsById(id))
            ? new ResponseEntity<>(projectRepository.save(project), HttpStatus.OK)
            : new ResponseEntity<>(projectRepository.save(project), HttpStatus.CREATED);
    }

    @DeleteMapping
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

    @RequestMapping(method = {RequestMethod.OPTIONS})
    public ResponseEntity<List<HttpMethod>> supportedOperations() {
        return ResponseEntity.ok()
                             .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS).build();
    }
}