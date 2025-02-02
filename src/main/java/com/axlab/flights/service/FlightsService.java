package com.axlab.flights.service;

import com.axlab.flights.repository.FlightsRepository;
import com.axlab.flights.exeption.BadRequestException;
import com.axlab.flights.exeption.NotFoundException;
import com.axlab.flights.modal.Flight;
import com.axlab.flights.modal.dto.FlightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightsService {

    private final FlightsRepository flightsRepository;

    public List<Flight> list() {
        return flightsRepository.findAll();
    }

    public Flight findById(long id) throws NotFoundException {
        return flightsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight #" + id + "not found"));
    }

    public Flight create(FlightDto flightDto) throws BadRequestException {
        validateFlightDto(flightDto);
        return flightsRepository.save(new Flight(flightDto.iataCarrierCode(),
                flightDto.number(),
                flightDto.date(),
                flightDto.iataOriginCode(),
                flightDto.iataDestinationCode()));
    }

    private void validateFlightDto(FlightDto flightDto) throws BadRequestException {
        try {
            Assert.hasText(flightDto.iataCarrierCode(), "IATA Carrier Code can't be empty");
            Assert.hasText(flightDto.number(), "Flight number can't be empty");
            Assert.hasText(flightDto.iataOriginCode(), "IATA origin code can't be empty");
            Assert.hasText(flightDto.iataDestinationCode(), "IATA destination Code can't be empty");
            Assert.notNull(flightDto.date(), "Flight date can't be null");
        } catch (Exception e){
            throw new BadRequestException(e);
        }
    }

    public void delete(Flight flight) {
        flightsRepository.delete(flight);
    }

    public Flight modify(Flight flight, FlightDto newFlight) throws BadRequestException {
        validateFlightDto(newFlight);

        flight.setDate(newFlight.date());
        flight.setNumber(newFlight.number());
        flight.setIataCarrierCode(newFlight.iataCarrierCode());
        flight.setIataOriginCode(newFlight.iataOriginCode());
        flight.setIataDestinationCode(newFlight.iataDestinationCode());

        return flightsRepository.save(flight);
    }
}
