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

class TicketControllerTest {

    @Mock
    TicketService ticketService;

    @InjectMocks
    TicketController ticketController;


    TrainTicket trainTicket = new TrainTicket();
    User user = new User();

    Seat seat = new Seat();
    Map<String, TrainTicket> tickets = new HashMap<>();
    Map<String, Seat> seats = new HashMap<>();
    Map<String, User> users = new HashMap<>();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        user.setEmail("ajith.j@qbrainx.com");
        user.setFirstName("Ajith");
        user.setLastName("Abi");
        user.setSeat(seat);

        users.put("1", user);

        seat.setSeatNumber(1);
        seat.setSection("A");

        seats.put("1",seat);

        trainTicket.setTo("Chennai");
        trainTicket.setFrom("Erode");
        trainTicket.setPricePaid("20$");
        trainTicket.setUser(user);

        tickets.put("1",trainTicket);
    }

    @Test
    void purchaseTicket() {
        when(ticketService.createTicket(trainTicket)).thenReturn("Ticket successfully purchased");
        ResponseEntity<String> responseEntity = ticketController.purchaseTicket(trainTicket);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Ticket successfully purchased", responseEntity.getBody());
    }

    @Test
    void getTicket() {
        String ticketId = "1";
        when(ticketService.getTicket(ticketId)).thenReturn(trainTicket);
        ResponseEntity<TrainTicket> responseEntity = ticketController.getTicket(ticketId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(trainTicket, responseEntity.getBody());
    }

    @Test
    void getUsersBySection() {
        String section = "A";
        when(ticketService.getSections(section)).thenReturn(users);
        ResponseEntity<Map<String, User>> responseEntity = ticketController.getUsersBySection(section);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(users, responseEntity.getBody());
    }


}