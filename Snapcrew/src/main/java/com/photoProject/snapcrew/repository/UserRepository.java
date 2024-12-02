package com.photoProject.snapcrew.repository;

import com.photoProject.snapcrew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Additional queries, if needed, can be added here
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
