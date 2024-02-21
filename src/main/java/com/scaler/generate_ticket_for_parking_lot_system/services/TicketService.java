package com.scaler.generate_ticket_for_parking_lot_system.services;

import com.scaler.generate_ticket_for_parking_lot_system.exceptions.InvalidGateException;
import com.scaler.generate_ticket_for_parking_lot_system.exceptions.InvalidParkingLotException;
import com.scaler.generate_ticket_for_parking_lot_system.exceptions.ParkingSpotNotAvailableException;
import com.scaler.generate_ticket_for_parking_lot_system.models.Ticket;

public interface TicketService {
    // Do not modify the method signatures, feel free to add new methods
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException;
}
