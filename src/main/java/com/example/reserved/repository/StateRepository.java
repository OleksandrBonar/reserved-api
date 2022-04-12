package com.example.reserved.repository;

import com.example.reserved.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface StateRepository extends CrudRepository<State, Long> {}
