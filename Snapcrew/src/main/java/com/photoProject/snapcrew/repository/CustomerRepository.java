package com.photoProject.snapcrew.repository;

import com.photoProject.snapcrew.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
