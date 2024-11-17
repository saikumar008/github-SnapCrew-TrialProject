package com.photoProject.Snapcrew.Enums;

import java.util.Optional;

public enum UserRole {
    CUSTOMER, PHOTOGRAPHER;


    public String getRole() {
        return "ROLE_" + this.name();
    }
}
