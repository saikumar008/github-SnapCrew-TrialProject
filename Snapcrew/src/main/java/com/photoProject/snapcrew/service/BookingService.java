package com.photoProject.snapcrew.service;

import com.photoProject.snapcrew.dto.BookingDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    public BookingDto createBooking(UUID bookingPhotographerId, BookingDto bookingDto);

    public BookingDto getBookingById(UUID id);

    public List<BookingDto> getAllBookings();

    public BookingDto updateBooking(UUID bookingId,UUID bookingPhotographerId,UUID hiredPhotographerId, BookingDto bookingDto);

    public void deleteBooking(UUID id);
}
