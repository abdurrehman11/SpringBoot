package com.infotech.SpringBootJunitTesting.service;

import com.infotech.SpringBootJunitTesting.dao.TicketBookingDao;
import com.infotech.SpringBootJunitTesting.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }

    public Ticket getTicketById(Integer ticketId) {
        Ticket ticket = ticketBookingDao.findById(ticketId).get();
        return ticket;
    }

    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }

    public Ticket getTicketByEmail(String email) {
        return ticketBookingDao.findByEmail(email);
    }

    public void deleteTicket(Integer ticketId) {
        ticketBookingDao.deleteById(ticketId);
    }

    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get();
        ticketFromDb.setEmail(newEmail);
        Ticket upadedTicket = ticketBookingDao.save(ticketFromDb);
        return upadedTicket;
    }
}