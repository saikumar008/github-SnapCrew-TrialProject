package com.photoProject.Snapcrew.Entity;

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
@Table(name = "Booking ")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "photographer_Id")
    private Photographer photographer;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "booking_details")
    private String eventDetails;

    @Column(name = "booking_price")
    private double price;

    // Getters and Setters
}

