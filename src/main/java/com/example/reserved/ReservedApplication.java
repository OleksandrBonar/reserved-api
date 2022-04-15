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
            Country ukraine = countryRepository.save(new Country("Ukraine"));

            State kyivska = stateRepository.save(new State("Kyivska", ukraine));

            City kyiv = cityRepository.save(new City("Kyiv", kyivska));
            City brovary = cityRepository.save(new City("Brovary", kyivska));

            Address addr1 = addressRepository.save(new Address("2, Nezalezhnosti Blvd.", brovary));
            Address addr2 = addressRepository.save(new Address("16, Nezalezhnosti Blvd.", brovary));
            Address addr3 = addressRepository.save(new Address("17, Nezalezhnosti Blvd.", brovary));
            Address addr4 = addressRepository.save(new Address("257, Kyivska St.", brovary));
            Address addr5 = addressRepository.save(new Address("265, Kyivska St.", brovary));
            Address addr6 = addressRepository.save(new Address("314, Kyivska St.", brovary));
            Address addr7 = addressRepository.save(new Address("28B, Haharina St.", brovary));
            Address addr8 = addressRepository.save(new Address("3, Heroiv UPA St.", brovary));

            // create and save new restaurants
            Restaurant rest1 = restaurantRepository.save(new Restaurant("Meat. Fish. Two Knives", addr5));
            Restaurant rest2 = restaurantRepository.save(new Restaurant("Sous Cafe", addr3));
            Restaurant rest3 = restaurantRepository.save(new Restaurant("Shtrudel", addr1));
            Restaurant rest4 = restaurantRepository.save(new Restaurant("UNO Pizza&Grill", addr4));
            Restaurant rest5 = restaurantRepository.save(new Restaurant("Brovar-Khof", addr6));
            Restaurant rest6 = restaurantRepository.save(new Restaurant("La`Terrassa Cafe", addr2));
            Restaurant rest7 = restaurantRepository.save(new Restaurant("Charivna Taistra", addr7));
            Restaurant rest8 = restaurantRepository.save(new Restaurant("Santorin", addr8));

            // create and save new desks
            Desk desk1 = deskRepository.save(new Desk(4, rest2));
            Desk desk2 = deskRepository.save(new Desk(4, rest2));
            Desk desk3 = deskRepository.save(new Desk(4, rest2));
            Desk desk4 = deskRepository.save(new Desk(4, rest2));
            Desk desk5 = deskRepository.save(new Desk(4, rest2));

            // create and save new persons
            Person jamesDoe = personRepository.save(new Person("James", "Doe", "+1234567890"));
            Person judyDoe = personRepository.save(new Person("Judy", "Doe", "+1234567891"));

            // create and save new bookings
            Booking bkg1 = bookingRepository.save(new Booking(
                    jamesDoe,
                    desk1,
                    LocalDateTime.parse("2007-12-02T10:15:30"),
                    LocalDateTime.parse("2007-12-03T10:00:00"),
                    LocalDateTime.parse("2007-12-03T14:00:00")
            ));
            Booking bkg2 = bookingRepository.save(new Booking(
                    jamesDoe,
                    desk2,
                    LocalDateTime.parse("2007-12-02T10:15:30"),
                    LocalDateTime.parse("2007-12-03T10:00:00"),
                    LocalDateTime.parse("2007-12-03T14:00:00")
            ));
        };
    }
}
