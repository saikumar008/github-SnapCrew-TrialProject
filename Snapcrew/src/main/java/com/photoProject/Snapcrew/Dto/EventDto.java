package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Entity.Photographer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {


    private String eventName;

    private LocalDate eventDate;

    private String location;

    private Photographer photographer;
}
