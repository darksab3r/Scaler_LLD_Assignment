package com.scaler.generate_ticket_for_parking_lot_system.respositories;

import com.scaler.generate_ticket_for_parking_lot_system.models.Gate;

import java.util.Optional;

public interface GateRepository {
    // Do not modify the method signatures, feel free to add new methods

    public Optional<Gate> findById(long gateId);

    public Gate save(Gate gate);
}
