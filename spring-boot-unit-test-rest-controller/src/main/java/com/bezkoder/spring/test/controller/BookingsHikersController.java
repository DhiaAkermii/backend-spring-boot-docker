package com.bezkoder.spring.test.controller;


import com.bezkoder.spring.test.model.Trail;
import com.bezkoder.spring.test.model.Booking;
import com.bezkoder.spring.test.model.BookingsHikers;
import com.bezkoder.spring.test.model.Hiker;
import com.bezkoder.spring.test.repository.BookingsHikersRepository;
import com.bezkoder.spring.test.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class BookingsHikersController {

    private final BookingsHikersRepository bookingsHikersRepository;
    private final BookingRepository bookingRepository;

    public BookingsHikersController(BookingsHikersRepository bookingsHikersRepository, BookingRepository bookingRepository) {
        this.bookingsHikersRepository = bookingsHikersRepository;
        this.bookingRepository = bookingRepository;
    }
    public static class MyData{
        private Trail trail;
        private List<Hiker> hikers;

        public MyData(Trail trail, List<Hiker> hikers) {
            this.trail= trail;
            this.hikers = hikers;
        }

        public Trail getTrail() {
            return trail;
        }

        public void setTrail(Trail trail) {
            this.trail = trail;
        }

        public List<Hiker> getHikers() {
            return hikers;
        }

        public void setHikers(List<Hiker> hikers) {
            this.hikers = hikers;
        }
    }


    @PostMapping("bookings-hikers/create")
    public List<Hiker> createBooking(@RequestBody MyData myData ){
        Booking booking = new Booking(myData.getTrail());
        this.bookingRepository.save(booking);

        for(int i = 0 ; i < myData.getHikers().size();i++){
            BookingsHikers bookingHiker = new BookingsHikers(booking,myData.getHikers().get(i));
            this.bookingsHikersRepository.save(bookingHiker);
        }

        return myData.getHikers();
    }

    @GetMapping("bookings-hikers")
    public ResponseEntity<List<BookingsHikers>> getAllTrails(){
        return  ResponseEntity.ok(this.bookingsHikersRepository.findAll());
    }

    @GetMapping("/bookings-hikers/{id}")
    public ResponseEntity<List<BookingsHikers>> getBooking(@PathVariable(value = "id") Integer id){
        List<BookingsHikers> l = new ArrayList<>() ;
        List<BookingsHikers> l1 = this.bookingsHikersRepository.findAll();
        for(int i = 0 ; i < l1.size();i++){
            if(l1.get(i).getBooking().getId()==id){
                l.add(l1.get(i));
            }
        }
        return  ResponseEntity.ok(l);

    }

}
