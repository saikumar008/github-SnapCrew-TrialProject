package com.photoProject.snapcrew.enums;

public enum UserRole {
    CUSTOMER, PHOTOGRAPHER, ADMIN;

    public String getRole() {
        return "ROLE_" + this.name();
    }
}
