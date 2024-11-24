package com.photoProject.snapcrew.dto;

import com.photoProject.snapcrew.entity.Customer;
import com.photoProject.snapcrew.entity.Event;
import com.photoProject.snapcrew.entity.Photographer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {


    private UUID id;

    private Customer customer;

    // The photographer who is booking another photographer
    private Photographer bookingPhotographer;

    // The photographer being booked for the event
    private Photographer hiredPhotographer;

    private LocalDateTime bookingDate;

    private String eventDetails;

    private double price;

    // Link to the Event entity
    private Event event;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Photographer getBookingPhotographer() {
        return bookingPhotographer;
    }

    public void setBookingPhotographer(Photographer bookingPhotographer) {
        this.bookingPhotographer = bookingPhotographer;
    }

    public Photographer getHiredPhotographer() {
        return hiredPhotographer;
    }

    public void setHiredPhotographer(Photographer hiredPhotographer) {
        this.hiredPhotographer = hiredPhotographer;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
