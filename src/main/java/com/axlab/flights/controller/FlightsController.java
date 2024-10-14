package com.axlab.flights.controller;

import com.axlab.flights.exeption.BadRequestException;
import com.axlab.flights.exeption.NotFoundException;
import com.axlab.flights.mapper.FlightsMapper;
import com.axlab.flights.modal.Flight;
import com.axlab.flights.modal.dto.FlightDto;
import com.axlab.flights.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightsMapper flightsMapper;
    private final FlightsService flightsService;


    @GetMapping
    private List<FlightDto> list() {
        return flightsMapper.toFlightDto(flightsService.list());
    }

    @GetMapping("/{id}")
    private FlightDto findById(@PathVariable long id) throws NotFoundException {
        return flightsMapper.toFlightDto(flightsService.findById(id));
    }

    @PostMapping
    private FlightDto create(@RequestBody FlightDto flightDto) throws BadRequestException {
        return flightsMapper.toFlightDto(flightsService.create(flightDto));
    }

    @PutMapping("/{id}")
    private FlightDto modify(@PathVariable long id, @RequestBody FlightDto flightDto) throws NotFoundException, BadRequestException {
        Flight flight = flightsService.findById(id);
        return flightsMapper.toFlightDto(flightsService.modify(flight, flightDto));
    }

    @DeleteMapping("/{id}")
    private Map<String, Boolean> delete(@PathVariable long id) throws NotFoundException {
        flightsService.delete(flightsService.findById(id));
        return Collections.singletonMap("Deleted", true);
    }
}
