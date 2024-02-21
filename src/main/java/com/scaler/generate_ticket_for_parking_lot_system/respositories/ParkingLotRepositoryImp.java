package com.scaler.generate_ticket_for_parking_lot_system.respositories;

import com.scaler.generate_ticket_for_parking_lot_system.models.Gate;
import com.scaler.generate_ticket_for_parking_lot_system.models.ParkingLot;

import java.util.*;

public class ParkingLotRepositoryImp implements ParkingLotRepository{

    private final List<ParkingLot> parkingLotList = new ArrayList<>();
    @Override
    public Optional<ParkingLot> getParkingLotByGateId(long gateId) {
        for(ParkingLot parkingLot: parkingLotList){
            List<Gate> gates = parkingLot.getGates();
            for(Gate gate: gates){
                if(gate.getId()==gateId){
                    return Optional.of(parkingLot);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ParkingLot> getParkingLotById(long id) {
        for(ParkingLot parkingLot: parkingLotList){
            if(parkingLot.getId()==id){
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
        return parkingLot;
    }
}
