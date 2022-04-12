package com.example.reserved.repository;

import com.example.reserved.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface BookingRepository extends CrudRepository<Booking, Long> {}
