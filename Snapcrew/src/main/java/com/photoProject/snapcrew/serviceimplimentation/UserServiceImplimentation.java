package com.photoProject.snapcrew.serviceimplimentation;

import com.photoProject.snapcrew.dto.UserDto;
import com.photoProject.snapcrew.entity.*;
import com.photoProject.snapcrew.enums.UserRole;
import com.photoProject.snapcrew.repository.*;
import com.photoProject.snapcrew.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplimentation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PortfolioItemRepository  portfolioItemRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PhotographerQuoteRepository photographerQuoteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
    }

    public UserDto createUser(UserDto userDto) {

        // Validate if user already exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("User already exists with email: " + userDto.getEmail());
        }

        // Validate password strength
        if (userDto.getPassword() == null || userDto.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // Encode the password
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Map DTO to entity
        User user = modelMapper.map(userDto, User.class);

        try {
            // Save the user first to generate the user ID
            User savedUser = userRepository.save(user);

            // Check the role and create an associated Photographer or Customer
            if (userDto.getRole() == UserRole.PHOTOGRAPHER) {
                Photographer photographer = new Photographer();
                photographer.setUser(savedUser);


                Photographer savedPhotographer = photographerRepository.save(photographer);

                // Automatically create a default PortfolioItem for the new Photographer
                PortfolioItem portfolioItem = new PortfolioItem();
                portfolioItem.setPhotographer(savedPhotographer); // Link with the created photographer
//                portfolioItem.setItemTitle("Default Portfolio Title"); // Placeholder title
//                portfolioItem.setItemDescription("Default Description"); // Placeholder description
                portfolioItemRepository.save(portfolioItem);

                Booking booking = new Booking();
                booking.setBookingPhotographer(savedPhotographer);
                bookingRepository.save(booking);

                Event event = new Event();
                event.setPhotographer(savedPhotographer); // Link Event to Photographer
                eventRepository.save(event);

                PhotographerQuote photographerQuote = new PhotographerQuote();
                photographerQuote.setHiringPhotographer(savedPhotographer);
                photographerQuoteRepository.save(photographerQuote);
                
            } else if (userDto.getRole() == UserRole.CUSTOMER) {
                Customer customer = new Customer();
                customer.setUser(savedUser);
                customerRepository.save(customer);
            }

            // Return the saved user details as a DTO
            return modelMapper.map(savedUser, UserDto.class);

        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public UserDto updateUser(UUID id, UserDto userDto) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setMobileNumber(userDto.getMobileNumber());

            // Only encode and update password if a new password is provided
            if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }

            user.setRole(userDto.getRole());
            User updatedUser = userRepository.save(user);
            return modelMapper.map(updatedUser, UserDto.class);
        } else {
            return null;  // Handle user not found case
        }
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
