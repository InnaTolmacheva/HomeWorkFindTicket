package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int lenght = tickets.length + 1;
        Ticket[] tmp = new Ticket[lenght];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;

    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void removeByI(int id) {
        int lenght = tickets.length - 1;
        Ticket[] tmp = new Ticket[lenght];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
    }
}
