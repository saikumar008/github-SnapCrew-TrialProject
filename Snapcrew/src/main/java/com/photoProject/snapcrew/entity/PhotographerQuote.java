package com.photoProject.snapcrew.entity;

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
@Table(name = "photographerQuote")
public class PhotographerQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "hiring_Photographer_Id")
    private Photographer hiringPhotographer;

    @ManyToOne
    @JoinColumn(name = "hired_Photographer_Id")
    private Photographer hiredPhotographer;

    @Column(name = "quote_amount")
    private double quoteAmount;

    @Column(name = "quote_message")
    private String message;

    @Column(name = "quote_date")
    private LocalDate date;

    // Getters and setters


    public Photographer getHiringPhotographer() {
        return hiringPhotographer;
    }

    public void setHiringPhotographer(Photographer hiringPhotographer) {
        this.hiringPhotographer = hiringPhotographer;
    }

    public Photographer getHiredPhotographer() {
        return hiredPhotographer;
    }

    public void setHiredPhotographer(Photographer hiredPhotographer) {
        this.hiredPhotographer = hiredPhotographer;
    }

    public double getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(double quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

