package com.example.reserved.repository;

import com.example.reserved.entity.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    @RestResource(path = "byName", rel = "byName")
    List<City> findByNameContaining(@Param("query") String query, Pageable page);

    @RestResource(path = "byStateId", rel = "byStateId")
    List<City> findByStateId(@Param("id") Long id);

    @RestResource(path = "byStateName", rel = "byStateName")
    List<City> findByStateNameContaining(@Param("name") String name, Pageable page);

    @RestResource(path = "byCountryId", rel = "byCountryId")
    List<City> findByCountryId(@Param("id") Long id);

    @RestResource(path = "byCountryName", rel = "byCountryName")
    List<City> findByCountryNameContaining(@Param("name") String name, Pageable page);
}
