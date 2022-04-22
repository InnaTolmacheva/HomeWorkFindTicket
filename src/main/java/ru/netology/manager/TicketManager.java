package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {

    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findTicket(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTickets()) {
            if (matches(ticket, from, to)) {
                int lenght = result.length + 1;
                Ticket[] tmp = new Ticket[lenght];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] findTicketSortedByPrice(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTickets()) {
            if (matches(ticket, from, to)) {
                int lenght = result.length + 1;
                Ticket[] tmp = new Ticket[lenght];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;


    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getAirFrom().contains(searchFrom) && ticket.getAirTo().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}
