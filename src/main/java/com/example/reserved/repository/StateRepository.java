package com.example.reserved.repository;

import com.example.reserved.entity.State;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface StateRepository extends PagingAndSortingRepository<State, Long> {
    @RestResource(path = "byName", rel = "byName")
    List<State> findByNameContaining(@Param("name") String name, Pageable page);

    @RestResource(path = "byCountryId", rel = "byCountryId")
    List<State> findByCountryId(@Param("id") Long id);

    @RestResource(path = "byCountryName", rel = "byCountryName")
    List<State> findByCountryNameContaining(@Param("name") String name, Pageable page);
}
