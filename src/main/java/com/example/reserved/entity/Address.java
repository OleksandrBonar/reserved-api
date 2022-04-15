package com.example.reserved.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line1", nullable = false)
    @Size(min = 3, message = "{address.line.size}")
    @NotBlank(message = "{address.line.notBlank}")
    private String line1;

    @Column(name = "line2", nullable = false)
    private String line2;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;

    public Address() {
    }

    public Address(Long id, String line1, City city) {
        this.id = id;
        this.line1 = line1;
        this.line2 = "";
        this.city = city;
    }

    public Address(Long id, String line1, String line2, City city) {
        this.id = id;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
