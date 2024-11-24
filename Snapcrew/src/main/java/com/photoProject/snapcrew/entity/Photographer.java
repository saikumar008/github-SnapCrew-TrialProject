package com.photoProject.snapcrew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
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
    @JsonIgnore
    private List<PortfolioItem> portfolio;

    public Photographer() {
    }

    public Photographer(UUID id) {
        this.id = id;
    }

    public Photographer(UUID id, User user, String experience, String pricing, String about, String location, double rating, List<PortfolioItem> portfolio) {
        this.id = id;
        this.user = user;
        this.experience = experience;
        this.pricing = pricing;
        this.about = about;
        this.location = location;
        this.rating = rating;
        this.portfolio = portfolio;
    }

    public Photographer(UUID id, Object o) {
    }




    // Getters and setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<PortfolioItem> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<PortfolioItem> portfolio) {
        this.portfolio = portfolio;
    }
}
