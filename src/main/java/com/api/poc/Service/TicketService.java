package com.api.poc.Service;

import com.api.poc.Model.Seat;
import com.api.poc.Model.TrainTicket;
import com.api.poc.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class TicketService {


    private final Map<String, TrainTicket> tickets = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Seat> seats = new HashMap<>();

    private final AtomicLong ticketCounter = new AtomicLong(0);

    public String createTicket(TrainTicket ticket) {
        long ticketId = ticketCounter.incrementAndGet();
        tickets.put(String.valueOf(ticketId), ticket);
        users.put(String.valueOf(ticketId), ticket.getUser());
        seats.put(String.valueOf(ticketId), ticket.getUser().getSeat());
        return String.valueOf(ticketId);
    }

    public TrainTicket getTicket(String ticketNo) {
        TrainTicket ticket = tickets.get(ticketNo);
        if (ticket == null) {
            log.error("Ticket does not exist {}", ticketNo);
            return new TrainTicket();
        }
        return ticket;
    }

    public Map<String, User> getSections(String seatSection) {
        Map<String, User> usersInSection = new HashMap<>();
        for (Map.Entry<String, Seat> entry : seats.entrySet()) {
            if (entry.getValue().getSection().equalsIgnoreCase(seatSection)) {
                usersInSection.put(entry.getKey(), users.get(entry.getKey()));
            }
        }
        return usersInSection;
    }

    public void deleteTicketId(String ticketId) {
        if (tickets.containsKey(ticketId)) {
            tickets.remove(ticketId);
            users.remove(ticketId);
            seats.remove(ticketId);
            log.info("Deleted ticket id {}", ticketId);
        }
        else {
            log.error("Ticket id {} not found", ticketId);
        }

    }


    public void editSeat(String ticketId, Seat newSeat) {
        if (seats.containsKey(ticketId) && tickets.containsKey(ticketId)) {
            seats.put(ticketId, newSeat);
            var ticks = tickets.get(ticketId);
            User updatedUser = ticks.getUser().setSeat(newSeat.getSection(), newSeat.getSeatNumber());
            ticks.setUser(updatedUser);
            tickets.put(ticketId, ticks);
            log.info("Seat information updated successfully.");
            System.out.println("Seat information updated successfully.");
        } else {
            log.info("Ticket ID does not exist.");
            System.out.println("Ticket ID does not exist.");
        }
    }


}
