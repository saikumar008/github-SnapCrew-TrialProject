package com.photoProject.snapcrew.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    // The photographer who is booking another photographer
    @ManyToOne
    @JoinColumn(name = "booking_photographer_id")
    private Photographer bookingPhotographer;

    // The photographer being booked for the event
    @ManyToOne
    @JoinColumn(name = "hired_photographer_id")
    private Photographer hiredPhotographer;


    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "booking_details")
    private String eventDetails;

    @Column(name = "booking_price")
    private double price;

    // Link to the Event entity
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;
    // Getters and Setters


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
}

