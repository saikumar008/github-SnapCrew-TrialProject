package com.photoProject.snapcrew.serviceimplimentation;

import com.photoProject.snapcrew.entity.User;
import com.photoProject.snapcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        User user1 = userRepo.findByEmail(email);
        return user1;
    }

}
