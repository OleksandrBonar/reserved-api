package com.example.reserved;

import com.example.reserved.entity.*;
import com.example.reserved.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReservedApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ReservedApplication.class, args);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(State.class);
        config.exposeIdsFor(City.class);
        config.exposeIdsFor(Address.class);

        config.exposeIdsFor(Person.class);
        config.exposeIdsFor(Restaurant.class);
        config.exposeIdsFor(Desk.class);
        config.exposeIdsFor(Booking.class);
    }

    @Bean
    public CommandLineRunner mappingDemo(
            CountryRepository countryRepository,
            StateRepository stateRepository,
            CityRepository cityRepository,
            AddressRepository addressRepository,

            PersonRepository personRepository,
            RestaurantRepository restaurantRepository,
            DeskRepository deskRepository,
            BookingRepository bookingRepository
    ) {
        return args -> {
            // create and save addresses
            countryRepository.save(new Country(1L, "Ukraine"));

            stateRepository.save(new State(1L, "Kyivska", countryRepository.findById(1L).get()));

            cityRepository.save(new City(1L, "Kyiv", stateRepository.findById(1L).get(), countryRepository.findById(1L).get()));
            cityRepository.save(new City(2L, "Brovary", stateRepository.findById(1L).get(), countryRepository.findById(1L).get()));

            addressRepository.save(new Address(1L, "2, Nezalezhnosti Blvd.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(2L, "16, Nezalezhnosti Blvd.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(3L, "17, Nezalezhnosti Blvd.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(4L, "257, Kyivska St.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(5L, "265, Kyivska St.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(6L, "314, Kyivska St.", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(7L, "28B, Haharina St.", "", cityRepository.findById(2L).get()));
            addressRepository.save(new Address(8L, "3, Heroiv UPA St.", "", cityRepository.findById(2L).get()));

            // create and save new restaurants
            restaurantRepository.save(new Restaurant(1L, "Meat. Fish. Two Knives", addressRepository.findById(5L).get()));
            restaurantRepository.save(new Restaurant(2L, "Sous Cafe", addressRepository.findById(3L).get()));
            restaurantRepository.save(new Restaurant(3L, "Shtrudel", addressRepository.findById(1L).get()));
            restaurantRepository.save(new Restaurant(4L, "UNO Pizza&Grill", addressRepository.findById(4L).get()));
            restaurantRepository.save(new Restaurant(5L, "Brovar-Khof", addressRepository.findById(6L).get()));
            restaurantRepository.save(new Restaurant(6L, "La`Terrassa Cafe", addressRepository.findById(2L).get()));
            restaurantRepository.save(new Restaurant(7L, "Charivna Taistra", addressRepository.findById(7L).get()));
            restaurantRepository.save(new Restaurant(8L, "Santorin", addressRepository.findById(8L).get()));

            // create and save new desks
            deskRepository.save(new Desk(1L, 4, restaurantRepository.findById(2L).get()));
            deskRepository.save(new Desk(2L, 4, restaurantRepository.findById(2L).get()));
            deskRepository.save(new Desk(3L, 4, restaurantRepository.findById(2L).get()));
            deskRepository.save(new Desk(4L, 4, restaurantRepository.findById(2L).get()));
            deskRepository.save(new Desk(5L, 4, restaurantRepository.findById(2L).get()));

            // create and save new persons
            personRepository.save(new Person(1L, "James", "Doe", "+1234567890"));
            personRepository.save(new Person(2L, "Judy", "Doe", "+1234567891"));

            // create and save new bookings
            bookingRepository.save(new Booking(
                    1L,
                    personRepository.findById(1L).get(),
                    deskRepository.findByRestaurantId(2L).get(0),
                    restaurantRepository.findById(2L).get(),
                    LocalDateTime.parse("2007-12-03T10:15:30"),
                    LocalDateTime.parse("2007-12-03T10:15:30"),
                    LocalDateTime.parse("2007-12-03T10:15:30")
            ));
        };
    }
}
