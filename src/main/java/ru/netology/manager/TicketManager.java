package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

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

    public Ticket[] findTicket(String text1, String text2) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getTickets()) {
            if (matches(ticket, text1, text2)) {
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


    public boolean matches(Ticket ticket, String search1, String seach2) {
        if (ticket.getAirFrom().contains(search1) && ticket.getAirTo().contains(seach2)) {
            return true;
        } else {
            return false;
        }
    }
}
