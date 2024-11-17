package com.photoProject.Snapcrew.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "event_Name")
    private String eventName;

    @Column(name = "event_Date")
    private LocalDate eventDate;

    @Column(name = "event_Location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "photographer_Id")
    private Photographer photographer;

    // Getters and Setters
}

