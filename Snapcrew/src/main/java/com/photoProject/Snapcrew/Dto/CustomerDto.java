package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Entity.Booking;
import com.photoProject.Snapcrew.Entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {


    private User user;

    private List<Booking> bookings;
}
