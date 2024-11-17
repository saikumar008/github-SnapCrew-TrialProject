package com.photoProject.Snapcrew.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "portfolioItem")
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "item_title")
    private String title;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_photo_url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "photographer_id")
    private Photographer photographer;
}
