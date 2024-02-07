package com.api.poc.Controller;

import com.api.poc.Model.Seat;
import com.api.poc.Model.TrainTicket;
import com.api.poc.Model.User;
import com.api.poc.Service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class TicketControllerTest {

    @Mock
    TicketService ticketService;

    @InjectMocks
    TicketController ticketController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void purchaseTicket() {
        TrainTicket trainTicket = new TrainTicket();
        when(ticketService.createTicket(trainTicket)).thenReturn("Ticket successfully purchased");
        ResponseEntity<String> responseEntity = ticketController.purchaseTicket(trainTicket);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Ticket successfully purchased", responseEntity.getBody());
    }

    @Test
    void getTicket() {
        String ticketId = "123";
        TrainTicket trainTicket = new TrainTicket();
        when(ticketService.getTicket(ticketId)).thenReturn(trainTicket);
        ResponseEntity<TrainTicket> responseEntity = ticketController.getTicket(ticketId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(trainTicket, responseEntity.getBody());
    }

    @Test
    void getUsersBySection() {
        String section = "first";
        Map<String, User> users = new HashMap<>();
        when(ticketService.getSections(section)).thenReturn(users);
        ResponseEntity<Map<String, User>> responseEntity = ticketController.getUsersBySection(section);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(users, responseEntity.getBody());
    }

    @Test
    void removeUser() {
        String ticketId = "123";
        ticketController.removeUser(ticketId);
        verify(ticketService, times(1)).deleteTicketId(ticketId);
    }

    @Test
    void modifySeat() {
        String ticketId = "123";
        Seat newSeat = new Seat();
        ticketController.modifySeat(ticketId, newSeat);
        verify(ticketService, times(1)).editSeat(ticketId, newSeat);
    }
}