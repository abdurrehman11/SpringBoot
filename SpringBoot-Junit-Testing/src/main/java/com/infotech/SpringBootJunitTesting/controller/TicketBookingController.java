package com.infotech.SpringBootJunitTesting.controller;

import com.infotech.SpringBootJunitTesting.entities.Ticket;
import com.infotech.SpringBootJunitTesting.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @CrossOrigin
    @PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketBookingService.createTicket(ticket);
    }

    // in case of calling from another server running on different port (i.e. port:4200 for Angular Server)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/ticket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @CrossOrigin
    @GetMapping(value="/ticket/alltickets", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingService.getAllBookedTickets();
    }

    @CrossOrigin
    @GetMapping(value="/email/{email:.+}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Ticket getTicketByEmail(@PathVariable("email")String email){
        return ticketBookingService.getTicketByEmail(email);
    }

    @CrossOrigin
    @DeleteMapping(value="/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @CrossOrigin
    @PutMapping(value="/ticket/{ticketId}/{newEmail:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail") String newEmail){
        return ticketBookingService.updateTicket(ticketId, newEmail);
    }

}
