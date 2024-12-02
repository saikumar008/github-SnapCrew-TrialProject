package com.photoProject.snapcrew.controller;

import com.photoProject.snapcrew.dto.BookingDto;
import com.photoProject.snapcrew.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/createBooking")
    public ResponseEntity<BookingDto> createBooking(
            @RequestParam UUID userId,
            @RequestBody BookingDto bookingDto) {
        BookingDto createdBooking = bookingService.createBooking(userId, bookingDto);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // Get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable UUID id) {
        BookingDto bookingDto = bookingService.getBookingById(id);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }

    // Get all bookings
    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Update a booking
    @PutMapping("/{bookingPhotographerId}/{hiredPhotographerId}")
    public ResponseEntity<BookingDto> updateBooking(
            @PathVariable UUID bookingPhotographerId,
            @PathVariable UUID bookingId,
            @PathVariable UUID hiredPhotographerId,
            @RequestBody BookingDto bookingDto
    ) {
        BookingDto updatedBooking = bookingService.updateBooking(bookingPhotographerId,bookingId,hiredPhotographerId, bookingDto);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    // Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
