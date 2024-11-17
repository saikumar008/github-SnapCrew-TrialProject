package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Entity.PortfolioItem;
import com.photoProject.Snapcrew.Entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotographerDto {

    private UUID id;

    private User user;

    private String experience;

    private String pricing;

    private String about;

    private String location;

    private double rating;

    private List<PortfolioItem> portfolio;

    // Getters and Setters
}

