package com.scaler.generate_ticket_for_parking_lot_system.models;

public class Gate extends BaseModel{

    private String name;
    private GateType type;
    private ParkingAttendant parkingAttendant;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    public ParkingAttendant getParkingAttendant() {
        return parkingAttendant;
    }

    public void setParkingAttendant(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }
}
