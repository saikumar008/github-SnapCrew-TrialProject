package com.photoProject.Snapcrew.Serviceimplimentation;

import com.photoProject.Snapcrew.CustomExceptionHandling.ResourceNotFoundException;
import com.photoProject.Snapcrew.Dto.BookingDto;
import com.photoProject.Snapcrew.Entity.Booking;
import com.photoProject.Snapcrew.Entity.Customer;
import com.photoProject.Snapcrew.Entity.Photographer;
import com.photoProject.Snapcrew.Repository.BookingRepository;
import com.photoProject.Snapcrew.Repository.CustomerRepository;
import com.photoProject.Snapcrew.Repository.PhotographerRepository;
import com.photoProject.Snapcrew.Service.BookingService;
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
    private ModelMapper modelMapper;


    @Override
    public BookingDto createBooking(UUID customerId, UUID photographerId, BookingDto bookingDto) {
        // Fetch customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        // Fetch photographer by ID
        Photographer photographer = photographerRepository.findById(photographerId)
                .orElseThrow(() -> new ResourceNotFoundException("Photographer not found"));

        // Create and save the booking
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setPhotographer(photographer);
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setEventDetails(bookingDto.getEventDetails());
        booking.setPrice(bookingDto.getPrice());

        Booking savedBooking = bookingRepository.save(booking);
        return convertToDto(savedBooking);
    }

    private BookingDto convertToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setBookingDate(booking.getBookingDate());
        dto.setEventDetails(booking.getEventDetails());
        dto.setPrice(booking.getPrice());
        dto.setPhotographer(booking.getPhotographer());
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
        dto.setPhotographer(booking.getPhotographer());

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
    public BookingDto updateBooking(UUID id, BookingDto bookingDto) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        modelMapper.map(bookingDto, existingBooking);
        Booking updatedBooking = bookingRepository.save(existingBooking);
        return modelMapper.map(updatedBooking, BookingDto.class);
    }

    @Override
    public void deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }
}
