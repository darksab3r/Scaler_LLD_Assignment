package com.scaler.generate_ticket_for_parking_lot_system.respositories;

import com.scaler.generate_ticket_for_parking_lot_system.models.Gate;

import java.util.*;

public class GateRepositoryImp implements GateRepository{

    private final Map<Long,Gate> gates = new HashMap<>();
    @Override
    public Optional<Gate> findById(long gateId) {
        return Optional.ofNullable(gates.get(gateId));
    }

    @Override
    public Gate save(Gate gate) {
        gates.put(gate.getId(), gate);
        return gate;
    }
}
