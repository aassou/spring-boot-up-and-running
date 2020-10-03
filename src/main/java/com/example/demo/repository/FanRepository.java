package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Fan;

public interface FanRepository extends CrudRepository<Fan, Long> {
    
}
