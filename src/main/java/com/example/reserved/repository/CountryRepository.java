package com.example.reserved.repository;

import com.example.reserved.entity.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    @RestResource(path = "byName", rel = "byName")
    List<Country> findByNameContaining(@Param("name") String name, Pageable page);
}
