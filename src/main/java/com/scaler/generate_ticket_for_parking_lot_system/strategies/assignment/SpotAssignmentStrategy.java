package com.scaler.generate_ticket_for_parking_lot_system.strategies.assignment;

import com.scaler.generate_ticket_for_parking_lot_system.models.ParkingLot;
import com.scaler.generate_ticket_for_parking_lot_system.models.ParkingSpot;
import com.scaler.generate_ticket_for_parking_lot_system.models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    Optional<ParkingSpot> assignSpot(ParkingLot parkingLot, VehicleType vehicleType);

}
