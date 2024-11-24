package com.photoProject.snapcrew.dto;

import com.photoProject.snapcrew.entity.Booking;
import com.photoProject.snapcrew.entity.User;
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
