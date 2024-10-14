package com.axlab.flights.modal.dto;

import java.time.LocalDateTime;

public record FlightDto(
        Long id,
        String iataCarrierCode,
        String number,
        LocalDateTime date,
        String iataOriginCode,
        String iataDestinationCode,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
