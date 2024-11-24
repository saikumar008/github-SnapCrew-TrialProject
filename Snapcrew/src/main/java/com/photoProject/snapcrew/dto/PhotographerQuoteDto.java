package com.photoProject.snapcrew.dto;

import com.photoProject.snapcrew.entity.Photographer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PhotographerQuoteDto {


    private Photographer hiringPhotographer;

    private Photographer hiredPhotographer;

    private double quoteAmount;

    private String message;

    private LocalDate date;

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

    public PhotographerQuoteDto() {
    }

    // Your existing getters and setters...

    // Static method to get a new Builder instance
    public static Builder builder() {
        return new PhotographerQuoteDto.Builder();
    }

    // Builder class
    public static final class Builder {
        private final PhotographerQuoteDto dto;

        // Private constructor
        private Builder() {
            dto = new PhotographerQuoteDto();
        }

        public Builder hiringPhotographer(Photographer hiringPhotographer) {
            dto.setHiringPhotographer(hiringPhotographer);
            return this;
        }

        public Builder hiredPhotographer(Photographer hiredPhotographer) {
            dto.setHiredPhotographer(hiredPhotographer);
            return this;
        }

        public Builder quoteAmount(double quoteAmount) {
            dto.setQuoteAmount(quoteAmount);
            return this;
        }

        public Builder message(String message) {
            dto.setMessage(message);
            return this;
        }

        public Builder date(LocalDate date) {
            dto.setDate(date);
            return this;
        }

        public PhotographerQuoteDto build() {
            return dto;
        }
    }

    // Static build method
    public static PhotographerQuoteDto build(
            Photographer hiringPhotographer,
            Photographer hiredPhotographer,
            double quoteAmount,
            String message,
            LocalDate date) {

        return builder()
                .hiringPhotographer(hiringPhotographer)
                .hiredPhotographer(hiredPhotographer)
                .quoteAmount(quoteAmount)
                .message(message)
                .date(date)
                .build();
    }
}
