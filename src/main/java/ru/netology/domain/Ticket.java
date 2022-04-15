package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airFrom;
    private String airTo;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        Ticket ticket = (Ticket) o;
        return this.price - o.price;
    }
}

