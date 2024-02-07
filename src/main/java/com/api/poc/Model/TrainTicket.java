package com.api.poc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainTicket {
    private String from;
    private String to;
    private User user;
    private String pricePaid;
}
