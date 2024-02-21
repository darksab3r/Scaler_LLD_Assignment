package com.scaler.generate_ticket_for_parking_lot_system.respositories;

import com.scaler.generate_ticket_for_parking_lot_system.models.Ticket;

import java.util.*;

public class TicketRepositoryImp implements TicketRepository {

    private final List<Ticket> ticketList = new ArrayList<>();
    @Override
    public Ticket save(Ticket ticket) {
        ticketList.add(ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> getTicketById(long ticketId) {
        for(Ticket ticket:ticketList){
            if(ticket.getId()==ticketId){
                return Optional.of(ticket);
            }
        }
        return Optional.empty();
    }
}
