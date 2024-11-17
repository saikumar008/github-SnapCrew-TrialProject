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
public class PhotographerQuoteDto {


    private Photographer hiringPhotographer;

    private Photographer hiredPhotographer;

    private double quoteAmount;

    private String message;

    private LocalDate date;
}
