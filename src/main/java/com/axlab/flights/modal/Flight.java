package com.axlab.flights.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iataCarrierCode;
    private String number;
    private LocalDateTime date;
    private String iataOriginCode;
    private String iataDestinationCode;

    public Flight(String iataCarrierCode, String number, LocalDateTime date, String iataOriginCode, String iataDestinationCode) {
        this.iataCarrierCode = iataCarrierCode;
        this.number = number;
        this.date = date;
        this.iataOriginCode = iataOriginCode;
        this.iataDestinationCode = iataDestinationCode;
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
