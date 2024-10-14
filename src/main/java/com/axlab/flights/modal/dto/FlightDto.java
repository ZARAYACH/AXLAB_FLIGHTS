package com.axlab.flights.modal.dto;

import java.time.LocalDateTime;

public record FlightDto(
        Long id,
        String IATACarrierCode,
        String number,
        LocalDateTime date,
        String IATAOriginCode,
        String IATADestinationCode

) {
}
