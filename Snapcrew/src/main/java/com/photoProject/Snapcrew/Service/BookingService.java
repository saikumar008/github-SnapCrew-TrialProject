package com.photoProject.Snapcrew.Service;

import com.photoProject.Snapcrew.Dto.BookingDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    public BookingDto createBooking(UUID customerId, UUID photographerId, BookingDto bookingDto);

    public BookingDto getBookingById(UUID id);

    public List<BookingDto> getAllBookings();

    public BookingDto updateBooking(UUID id, BookingDto bookingDto);

    public void deleteBooking(UUID id);
}
