package com.bezkoder.spring.test.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "Trails")
public class Trail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String startAt;
    private String endAt;
    private double unitPrice;

    @JsonIgnore
    @OneToMany( mappedBy="trail" , cascade = CascadeType.ALL)
    private List <Booking> bookings;

    public Trail( String name, String startAt, String endAt, double unitPrice, List<Booking> bookings) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.unitPrice = unitPrice;
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Trail(){}



    public Trail(String name, String startAt, String endAt, double unitPrice) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


}