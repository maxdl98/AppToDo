package com.example.demo.repository;

import com.example.demo.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {

    public List<Ticket> findAll();

    @Query(value = "{}", fields = "{ email : 1, problematica : 1, contenuto : 1 }")
    List<DatiTickets> findAllEmails();






}
