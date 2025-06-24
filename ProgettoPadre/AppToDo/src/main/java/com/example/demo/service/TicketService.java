package com.example.demo.service;

import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }


    public Ticket salvaTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }






}
