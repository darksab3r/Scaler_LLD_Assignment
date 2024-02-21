package com.scaler.generate_ticket_for_parking_lot_system.controllers;

import com.scaler.generate_ticket_for_parking_lot_system.dtos.GenerateTicketRequestDto;
import com.scaler.generate_ticket_for_parking_lot_system.dtos.GenerateTicketResponseDto;
import com.scaler.generate_ticket_for_parking_lot_system.dtos.ResponseStatus;
import com.scaler.generate_ticket_for_parking_lot_system.models.Ticket;
import com.scaler.generate_ticket_for_parking_lot_system.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try{
            Ticket ticket = ticketService.generateTicket(requestDto.getGateId(), requestDto.getRegistrationNumber(), requestDto.getVehicleType());
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
