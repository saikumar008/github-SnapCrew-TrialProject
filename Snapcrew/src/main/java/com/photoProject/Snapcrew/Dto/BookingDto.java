package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Entity.Customer;
import com.photoProject.Snapcrew.Entity.Photographer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {


    private Customer customer;

    private Photographer photographer;

    private LocalDateTime bookingDate;

    private String eventDetails;

    private double price;

}
