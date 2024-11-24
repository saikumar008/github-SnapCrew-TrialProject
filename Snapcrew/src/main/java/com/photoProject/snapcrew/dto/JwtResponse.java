package com.photoProject.snapcrew.dto;

public class JwtResponse {
    private String jwtToken;
    private UserDto user;

    // Default constructor
    public JwtResponse() {
    }

    // All args constructor
    public JwtResponse(String jwtToken, UserDto user) {
        this.jwtToken = jwtToken;
        this.user = user;
    }

    // Getters and Setters
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    // ToString method
    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", user=" + user +
                '}';
    }

    // Builder pattern implementation
    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private UserDto user;

        JwtResponseBuilder() {
        }

        public JwtResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder user(UserDto user) {
            this.user = user;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, user);
        }
    }
}

