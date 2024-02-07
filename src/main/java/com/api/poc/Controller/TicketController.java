package com.api.poc.Controller;

import com.api.poc.Model.Seat;
import com.api.poc.Model.TrainTicket;
import com.api.poc.Model.User;
import com.api.poc.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tickets")
public class TicketController {


    @Autowired
    TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody TrainTicket ticket) {
        return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.OK);
    }
    @GetMapping("/{ticketId}")
    public ResponseEntity<TrainTicket> getTicket(@PathVariable String ticketId) {
        return new ResponseEntity<>(ticketService.getTicket(ticketId),HttpStatus.OK);
    }
    @GetMapping("/users/{section}")
    public ResponseEntity<Map<String, User>> getUsersBySection(@PathVariable String section) {
        return new ResponseEntity<>(ticketService.getSections(section),HttpStatus.OK);
    }

    @DeleteMapping("/{ticketId}")
    public void removeUser(@PathVariable String ticketId) {
         ticketService.deleteTicketId(ticketId);
    }

    @PutMapping("/{ticketId}/seat")
    public void modifySeat(@PathVariable String ticketId, @RequestBody Seat newSeat) {
         ticketService.editSeat(ticketId,newSeat);
    }








}
