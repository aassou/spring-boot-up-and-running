package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Tea;

public interface TeaRepository extends CrudRepository<Tea, Long> {
    
}
