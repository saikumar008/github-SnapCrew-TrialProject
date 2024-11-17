package com.photoProject.Snapcrew.Dto;

import com.photoProject.Snapcrew.Enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;

    private String email;

    private String password;

    private String mobileNumber;

    private UserRole role; // Either 'CUSTOMER' or 'PHOTOGRAPHER'


}
