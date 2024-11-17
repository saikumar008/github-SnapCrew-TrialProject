package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Entity.Photographer;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioItemDto {

    private String title;

    private String description;

    private String photoUrl;

    private Photographer photographer;
}
