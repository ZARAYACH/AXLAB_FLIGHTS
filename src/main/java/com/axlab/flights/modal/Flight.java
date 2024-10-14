package com.axlab.flights.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight {


    @Id
    private Long id;
    private String IATACarrierCode;
    private String number;
    private LocalDateTime date;
    private String IATAOriginCode;
    private String IATADestinationCode;

    public Flight(String IATACarrierCode, String number, LocalDateTime date, String IATAOriginCode, String IATADestinationCode) {
        this.IATACarrierCode = IATACarrierCode;
        this.number = number;
        this.date = date;
        this.IATAOriginCode = IATAOriginCode;
        this.IATADestinationCode = IATADestinationCode;
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
