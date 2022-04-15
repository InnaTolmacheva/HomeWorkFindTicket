package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();

    private Ticket ticket1 = new Ticket(1, 3200, "DME", "AER", 180);
    private Ticket ticket2 = new Ticket(2, 5500, "DME", "AER", 200);
    private Ticket ticket3 = new Ticket(3, 2900, "DME", "AER", 1440);
    private Ticket ticket4 = new Ticket(1, 6000, "VKO", "OVB", 800);
    private Ticket ticket5 = new Ticket(1, 5000, "VKO", "OVB", 300);
    private Ticket ticket6 = new Ticket(1, 1000, "VKO", "OVB", 1000);
    private Ticket ticket7 = new Ticket(1, 50000, "VKO", "OVB", 180);
    private Ticket ticket8 = new Ticket(1, 7580, "VOZ", "LED", 180);
    private Ticket ticket9 = new Ticket(1, 15400, "VOZ", "LED", 120);
    private Ticket ticket10 = new Ticket(1, 6550, "VOZ", "LED", 240);


    @Test
    void save() {
        repository.save(ticket1);
        repository.save(ticket2);

        Ticket[] expected = new Ticket[]{ticket1, ticket2};
        Ticket[] actual = repository.getTickets();

        assertArrayEquals(expected, actual);

    }
}