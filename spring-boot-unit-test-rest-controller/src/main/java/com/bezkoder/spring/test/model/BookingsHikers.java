package com.bezkoder.spring.test.model;

import javax.persistence.*;

@Entity
@Table(name = "BookingHikerss")
public class BookingsHikers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private Hiker hiker;

    public BookingsHikers(Booking booking, Hiker hiker) {

        this.booking = booking;
        this.hiker = hiker;
    }

    public BookingsHikers() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Hiker getHiker() {
        return hiker;
    }

    public void setHiker(Hiker hiker) {
        this.hiker = hiker;
    }


}
