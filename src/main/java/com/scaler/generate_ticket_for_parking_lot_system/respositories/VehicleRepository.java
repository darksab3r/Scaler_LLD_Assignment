package com.scaler.generate_ticket_for_parking_lot_system.respositories;

import com.scaler.generate_ticket_for_parking_lot_system.models.Vehicle;

import java.util.Optional;

public interface VehicleRepository {
    // Do not modify the method signatures, feel free to add new methods

    public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber);

    public Vehicle save(Vehicle vehicle);
}
