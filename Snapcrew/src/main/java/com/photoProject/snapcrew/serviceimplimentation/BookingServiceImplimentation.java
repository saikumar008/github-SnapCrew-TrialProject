package com.photoProject.snapcrew.serviceimplimentation;

import com.photoProject.snapcrew.customExceptionHandling.ResourceNotFoundException;
import com.photoProject.snapcrew.dto.BookingDto;
import com.photoProject.snapcrew.entity.Booking;
import com.photoProject.snapcrew.entity.Customer;
import com.photoProject.snapcrew.entity.Photographer;
import com.photoProject.snapcrew.entity.User;
import com.photoProject.snapcrew.repository.BookingRepository;
import com.photoProject.snapcrew.repository.CustomerRepository;
import com.photoProject.snapcrew.repository.PhotographerRepository;
import com.photoProject.snapcrew.repository.UserRepository;
import com.photoProject.snapcrew.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImplimentation implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BookingDto createBooking(UUID bookingPhotographerId, BookingDto bookingDto) {

        // Attempt to fetch Photographer by user ID
        Photographer photographer = photographerRepository.findById(bookingPhotographerId).orElse(null);

        // Attempt to fetch Customer by user ID if photographer is null
        Customer customer = null;
        if (photographer == null) {
            customer = customerRepository.findById(bookingPhotographerId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found as either Photographer or Customer"));
        }

        // Create and save the booking
        Booking booking = new Booking();

        // If the user is a Photographer
        if (photographer != null) {
            booking.setBookingPhotographer(photographer);
            // Optionally handle if you still need a customer to be set here
        }

        // If the user is a Customer
        if (customer != null) {
            booking.setCustomer(customer);
            // Optionally handle if you still need a photographer to be set here
        }

        // Set the booking details from the DTO
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setEventDetails(bookingDto.getEventDetails());
        booking.setPrice(bookingDto.getPrice());

        // Save the booking
        Booking savedBooking = bookingRepository.save(booking);

        return convertToDto(savedBooking);
    }


    private BookingDto convertToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setBookingDate(booking.getBookingDate());
        dto.setEventDetails(booking.getEventDetails());
        dto.setPrice(booking.getPrice());
        dto.setBookingPhotographer(booking.getBookingPhotographer());
        dto.setHiredPhotographer(booking.getHiredPhotographer());
        dto.setCustomer(booking.getCustomer());
        return dto;
    }


    @Override
    public BookingDto getBookingById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        BookingDto dto = new BookingDto();
        dto.setBookingDate(booking.getBookingDate());
        dto.setEventDetails(booking.getEventDetails());
        dto.setPrice(booking.getPrice());
        dto.setCustomer(booking.getCustomer());
        dto.setBookingPhotographer(booking.getBookingPhotographer());
        dto.setHiredPhotographer(booking.getHiredPhotographer());

        return dto;
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(booking -> modelMapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto updateBooking(UUID bookingId,UUID bookingPhotographerId, UUID hiredPhotographerId, BookingDto bookingDto) {
        // Validate the existence of the booking photographer
        Photographer bookingPhotographer = photographerRepository.findById(bookingPhotographerId)
                .orElseThrow(() -> new ResourceNotFoundException("Photographer not found with id: " + bookingPhotographerId));

        // Validate the existence of the hired photographer
        Photographer hiredPhotographer = photographerRepository.findById(hiredPhotographerId)
                .orElseThrow(() -> new ResourceNotFoundException("Hired Photographer not found with id: " + hiredPhotographerId));

        // Fetch the existing booking using bookingDto's ID
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));

        // Update the booking details with the new information
//        existingBooking.setBookingPhotographer(bookingPhotographer);
        existingBooking.setHiredPhotographer(hiredPhotographer);
        existingBooking.setBookingDate(bookingDto.getBookingDate());
        existingBooking.setEventDetails(bookingDto.getEventDetails());
        existingBooking.setPrice(bookingDto.getPrice());

        // Save the updated booking
        Booking updatedBooking = bookingRepository.save(existingBooking);

        // Convert the updated booking entity back to a DTO and return
        return modelMapper.map(updatedBooking, BookingDto.class);
    }


    @Override
    public void deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }
}
