package com.photoProject.Snapcrew.Repository;

import com.photoProject.Snapcrew.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
