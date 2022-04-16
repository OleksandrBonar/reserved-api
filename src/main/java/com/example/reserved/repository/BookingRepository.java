package com.example.reserved.repository;

import com.example.reserved.entity.Booking;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
    @RestResource(path = "byPersonId", rel = "byPersonId")
    List<Booking> findByPersonId(@Param("id") Long id);

    @RestResource(path = "byPersonName", rel = "byPersonName")
    List<Booking> findByPersonFirstNameContainingOrPersonLastNameContaining(
            @Param("name") String firstName,
            @Param("name") String lastName,
            Pageable page
    );

    @RestResource(path = "byPersonNameAndDate", rel = "byPersonNameAndDate")
    List<Booking> findByPersonFirstNameContainingOrPersonLastNameContainingAndReservedFromGreaterThanEqualAndReservedToLessThanEqual(
            @Param("name") String firstName,
            @Param("name") String lastName,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedFrom,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedTo
    );

    @RestResource(path = "byRestaurantId", rel = "byRestaurantId")
    List<Booking> findByRestaurantId(@Param("id") Long id);

    @RestResource(path = "byRestaurantIdAndDate", rel = "byRestaurantIdAndDate")
    List<Booking> findByRestaurantIdAndReservedFromGreaterThanEqualAndReservedToLessThanEqual(
            @Param("id") Long id,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedFrom,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedTo
    );

    @RestResource(path = "byRestaurantName", rel = "byRestaurantName")
    List<Booking> findByRestaurantNameContaining(@Param("name") String name, Pageable page);

    @RestResource(path = "byRestaurantNameAndDate", rel = "byRestaurantNameAndDate")
    List<Booking> findByRestaurantNameContainingAndReservedFromGreaterThanEqualAndReservedToLessThanEqual(
            @Param("name") String name,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedFrom,
            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reservedTo
    );
}
