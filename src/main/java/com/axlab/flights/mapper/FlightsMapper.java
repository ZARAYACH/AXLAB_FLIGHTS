package com.axlab.flights.mapper;

import com.axlab.flights.modal.Flight;
import com.axlab.flights.modal.dto.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@Component
public interface FlightsMapper {

    FlightDto toFlightDto(Flight flight);
    List<FlightDto> toFlightDto(List<Flight> flights);
}
