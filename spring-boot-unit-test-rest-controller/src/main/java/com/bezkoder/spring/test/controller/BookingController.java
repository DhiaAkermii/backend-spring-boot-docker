package com.bezkoder.spring.test.controller;

import com.bezkoder.spring.test.repository.TrailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.bezkoder.spring.test.repository.BookingRepository;
//import com.bezkoder.spring.test.repository.HikesRepository;
import com.bezkoder.spring.test.model.Booking;
import com.bezkoder.spring.test.model.Trail;
//import com.bezkoder.spring.test.model.Hikes;

@RestController
public class BookingController {
    private final BookingRepository bookingRepository;
    private final TrailRepository trailRepository;

    public static class MyData{
        List<Booking> booking;
        Integer id;

        public MyData(List<Booking> booking, Integer id) {
            this.booking = booking;
            this.id = id;
        }

        public List<Booking> getBooking() {
            return booking;
        }

        public void setBooking(List<Booking> booking) {
            this.booking = booking;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public BookingController(BookingRepository bookingRepository, TrailRepository trailRepositor) {
        this.bookingRepository = bookingRepository;
        this.trailRepository = trailRepositor;
    }



    @PostMapping("/bookings/create")
    public ResponseEntity<Booking> createBookingNew(@RequestBody Booking booking){
            return ResponseEntity.ok(this.bookingRepository.save(booking));

    }


    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return  ResponseEntity.ok(this.bookingRepository.findAll());
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable(value = "id") Integer id){
        return this.bookingRepository.findById(id).orElse(null);
    }

    @GetMapping("/bookings/count")
    public long countBookings() {
        return this.bookingRepository.findAll().size();
    }



    @DeleteMapping("/bookings/delete/{id}")
    public void deleteBooking(@PathVariable("id") Integer id){
        bookingRepository.deleteById(id);
    }
}