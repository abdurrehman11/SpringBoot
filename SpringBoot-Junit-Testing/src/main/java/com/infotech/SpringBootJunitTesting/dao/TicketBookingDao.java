package com.infotech.SpringBootJunitTesting.dao;

import com.infotech.SpringBootJunitTesting.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {

    Ticket findByEmail(String email);
}
