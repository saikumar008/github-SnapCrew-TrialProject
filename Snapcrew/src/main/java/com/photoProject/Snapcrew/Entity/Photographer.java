package com.photoProject.Snapcrew.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "photographers")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User user;

    @Column(name = "photographer_Experience")
    private String experience;

    @Column(name = "photographer_Pricing")
    private String pricing;

    @Column(name = "photographer_About")
    private String about;

    @Column(name = "photographer_Location")
    private String location;

    @Column(name = "photographer_Rating")
    private double rating;

    @OneToMany(mappedBy = "photographer", cascade = CascadeType.ALL)
    private List<PortfolioItem> portfolio;

    // Getters and setters
}
