package com.example.reserved.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "desks")
public class Desk {
    @Id
    private Long id;

    @Column(name = "num_chairs", nullable = false)
    private Integer numChairs;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Desk() {}
    public Desk(Long id, Integer numChairs, Restaurant restaurant) {
        this.id = id;
        this.numChairs = numChairs;
        this.restaurant = restaurant;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getNumChairs() { return numChairs; }
    public void setNumChairs(Integer num_chairs) { this.numChairs = num_chairs; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
