package com.infotech.SpringBootJunitTesting.service;

import com.infotech.SpringBootJunitTesting.dao.TicketBookingDao;
import com.infotech.SpringBootJunitTesting.entities.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TicketBookingServiceTest {

    @Mock
    private TicketBookingDao ticketBookingDao;

    @InjectMocks
    private TicketBookingService ticketBookingService;

    @Test
    public void testCreateTicket() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Martin Bingel");
        ticket.setSourceStation("Kolkata");
        ticket.setDestStation("Delhi");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");

        when(ticketBookingDao.save(ticket)).thenReturn(ticket);

        assertThat(ticketBookingService.createTicket(ticket)).isEqualTo(ticket);
    }

    @Test
    public void testGetTicketById() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Martin Bingel");
        ticket.setSourceStation("Kolkata");
        ticket.setDestStation("Delhi");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");

        when(ticketBookingDao.findById(1)).thenReturn(Optional.of(ticket));
        assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
    }

    @Test
    public void testGetAllBookedTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setPassengerName("Martin Bingel");
        ticket1.setSourceStation("Kolkata");
        ticket1.setDestStation("Delhi");
        ticket1.setBookingDate(new Date());
        ticket1.setEmail("martin.s2017@gmail.com");

        Ticket ticket2 = new Ticket();
        ticket2.setPassengerName("Sean Murphy");
        ticket2.setSourceStation("Kolkata");
        ticket2.setDestStation("Mumbai");
        ticket2.setBookingDate(new Date());
        ticket2.setEmail("sean.s2017@gmail.com");

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);

        when(ticketBookingDao.findAll()).thenReturn(ticketList);
        assertThat(ticketBookingService.getAllBookedTickets()).isEqualTo(ticketList);
    }

    @Test
    public void testGetTicketByEmail() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Martin Bingel");
        ticket.setSourceStation("Kolkata");
        ticket.setDestStation("Delhi");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");

        when(ticketBookingDao.findByEmail("martin.s2017@gmail.com")).thenReturn(ticket);
        assertThat(ticketBookingService.getTicketByEmail("martin.s2017@gmail.com")).isEqualTo(ticket);
    }

    @Test
    public void testDeleteTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Martin Bingel");
        ticket.setSourceStation("Kolkata");
        ticket.setDestStation("Delhi");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");

        doNothing().when(ticketBookingDao).deleteById(1);
        ticketBookingService.deleteTicket(1);
    }

    @Test
    public void testUpdateTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Martin Bingel");
        ticket.setSourceStation("Kolkata");
        ticket.setDestStation("Delhi");
        ticket.setBookingDate(new Date());
        ticket.setEmail("martin.s2017@gmail.com");

        when(ticketBookingDao.findById(1)).thenReturn(Optional.of(ticket));
        ticket.setEmail("martin.s2000@gmail.com");
        when(ticketBookingDao.save(ticket)).thenReturn(ticket);

        assertThat(ticketBookingService.updateTicket(1, "martin.s2000@gmail.com")).isEqualTo(ticket);
    }

}
