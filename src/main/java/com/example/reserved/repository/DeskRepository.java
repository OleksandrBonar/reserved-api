package com.example.reserved.repository;

import com.example.reserved.entity.Desk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface DeskRepository extends CrudRepository<Desk, Long> {
    List<Desk> findByRestaurantId(Long id);
}
