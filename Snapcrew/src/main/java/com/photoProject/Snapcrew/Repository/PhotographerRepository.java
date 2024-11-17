package com.photoProject.Snapcrew.Repository;

import com.photoProject.Snapcrew.Entity.Photographer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, UUID> {
    // Custom query methods if needed
    Page<Photographer> findAll(Pageable pageable);

    // Search photographers by name or keyword in their profile (e.g., description)
    @Query("SELECT p FROM Photographer p WHERE " +
            "LOWER(p.user.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.about) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Photographer> searchByKeyword(@Param("keyword") String keyword);
}

