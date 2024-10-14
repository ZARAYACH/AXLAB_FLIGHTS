package com.axlab.flights.repository;

import com.axlab.flights.modal.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Long> {
}
