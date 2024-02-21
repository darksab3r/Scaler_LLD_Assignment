package com.scaler.parking_lot.services;

import com.scaler.parking_lot.exceptions.*;
import com.scaler.parking_lot.models.*;
import com.scaler.parking_lot.respositories.*;
import com.scaler.parking_lot.strategies.assignment.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Random;

public class TicketServiceImp implements TicketService{
    TicketRepository ticketRepository;
    GateRepository gateRepository;
    ParkingLotRepository parkingLotRepository;
    SpotAssignmentStrategy spotAssignmentStrategy;
    VehicleRepository vehicleRepository;

    public TicketServiceImp(VehicleRepository vehicleRepository,TicketRepository ticketRepository,GateRepository gateRepository,ParkingLotRepository parkingLotRepository,SpotAssignmentStrategy spotAssignmentStrategy){
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException {
        Gate gate = gateRepository.findById(gateId).orElseThrow(() -> new InvalidGateException("Invalid Gate"));
        if (!GateType.ENTRY.equals(gate.getType())) {
            throw new InvalidGateException("Ticket cannot be generated at exit gate");
        }
        ParkingAttendant parkingAttendant = gate.getParkingAttendant();
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setVehicleType(VehicleType.valueOf(vehicleType));
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGateId(gateId)
                .orElseThrow(() -> new InvalidParkingLotException("Invalid ParkingLot"));
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, VehicleType.valueOf(vehicleType)).orElseThrow(() -> new ParkingSpotNotAvailableException("Parking spot not available"));
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setParkingAttendant(parkingAttendant);
        ticket.setId(new Random(1000000000000000000L).nextLong());
        parkingSpot.setStatus(ParkingSpotStatus.OCCUPIED);
        vehicleRepository.save(vehicle);
        ticketRepository.save(ticket);
        return ticket;

    }
}
