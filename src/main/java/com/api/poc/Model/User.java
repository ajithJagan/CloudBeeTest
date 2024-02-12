package com.api.poc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Seat seat;

    public User setSeat(String section, int seatNumber) {
        this.seat.setSection(section);
        this.seat.setSeatNumber(seatNumber);
        return this;
    }
}
