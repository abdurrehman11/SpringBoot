package com.infotech.SpringBootJunitTesting.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;

import com.infotech.SpringBootJunitTesting.entities.Ticket;
import com.infotech.SpringBootJunitTesting.service.TicketBookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketBookingController.class, secure = false)
public class TicketBookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketBookingService ticketBookingService;

    @Test
    public void testCreateTicket() throws Exception {

        Ticket mockTicket = new Ticket();
        mockTicket.setTicketId(1);
        mockTicket.setPassengerName("Martin Bingel");
        mockTicket.setSourceStation("Kolkata");
        mockTicket.setDestStation("Delhi");
        mockTicket.setBookingDate(new Date());
        mockTicket.setEmail("martin.s2017@gmail.com");

        String inputInJson = this.mapToJson(mockTicket);

        String URI = "/api/tickets/create";

        Mockito.when(ticketBookingService.createTicket(Mockito.any(Ticket.class))).thenReturn(mockTicket);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        Ticket output = jsonToObject(outputInJson, Ticket.class);

        assertEquals(output.getTicketId(), mockTicket.getTicketId());
        assertEquals(output.getEmail(), mockTicket.getEmail());
        assertEquals(output.getPassengerName(), mockTicket.getPassengerName());
        assertEquals(output.getBookingDate(), mockTicket.getBookingDate());
        assertEquals(output.getSourceStation(), mockTicket.getSourceStation());
        assertEquals(output.getDestStation(), mockTicket.getDestStation());

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    private <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
}
