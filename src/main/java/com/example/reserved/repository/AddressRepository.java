package com.example.reserved.repository;

import com.example.reserved.entity.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    @RestResource(path = "byLine", rel = "byLine")
    List<Address> findByLine1ContainingOrLine2Containing(
            @Param("line") String line1,
            @Param("line2") String line2,
            Pageable page
    );

    @RestResource(path = "byCityId", rel = "byCityId")
    List<Address> findByCityId(@Param("id") Long id);

    @RestResource(path = "byCityName", rel = "byCityName")
    List<Address> findByCityNameContaining(@Param("name") String name, Pageable page);
}
