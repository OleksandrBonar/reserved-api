package com.example.reserved.repository;

import com.example.reserved.entity.Desk;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface DeskRepository extends PagingAndSortingRepository<Desk, Long> {
    @RestResource(path = "byRestaurantId", rel = "byRestaurantId")
    List<Desk> findByRestaurantId(@Param("id") Long id);

    @RestResource(path = "byRestaurantName", rel = "byRestaurantName")
    List<Desk> findByRestaurantNameContaining(@Param("name") String name, Pageable page);
}
