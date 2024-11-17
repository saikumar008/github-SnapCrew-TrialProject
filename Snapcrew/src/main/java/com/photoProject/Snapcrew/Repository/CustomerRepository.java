package com.photoProject.Snapcrew.Repository;

import com.photoProject.Snapcrew.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
