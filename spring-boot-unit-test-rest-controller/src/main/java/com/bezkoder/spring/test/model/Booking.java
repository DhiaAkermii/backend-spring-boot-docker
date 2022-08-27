package com.bezkoder.spring.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bookings")
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Trail trail;

    @JsonIgnore
    @OneToMany( mappedBy="booking" , cascade = CascadeType.ALL)
    private List<BookingsHikers> booking;

    public Booking(){}

    public Booking(Trail trail) {
        this.trail = trail;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public List<BookingsHikers> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingsHikers> booking) {
        this.booking = booking;
    }
}