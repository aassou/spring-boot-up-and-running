package com.example.demo.repository;

import com.example.demo.domain.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    
}
