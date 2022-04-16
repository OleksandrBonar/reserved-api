package com.example.reserved.repository;

import com.example.reserved.entity.Restaurant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
    @RestResource(path = "byName", rel = "byName")
    List<Restaurant> findByNameContaining(@Param("name") String name);

    @RestResource(path = "byAddressLine", rel = "byAddressLine")
    List<Restaurant> findByAddressLine1ContainingOrAddressLine2Containing(
            @Param("line") String line1,
            @Param("line") String line2,
            Pageable page
    );

    @RestResource(path = "byCityId", rel = "byCityId")
    List<Restaurant> findByAddressCityId(@Param("id") Long id);

    @RestResource(path = "byCityName", rel = "byCityName")
    List<Restaurant> findByAddressCityNameContaining(@Param("name") String name);

    @RestResource(path = "byCountryId", rel = "byCountryId")
    List<Restaurant> findByAddressCityCountryId(@Param("id") Long id);

    @RestResource(path = "byCountryName", rel = "byCountryName")
    List<Restaurant> findByAddressCityCountryNameContaining(@Param("name") String name);
}
