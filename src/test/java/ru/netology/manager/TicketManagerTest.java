package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketManager manager = new TicketManager();
    private Ticket ticket1 = new Ticket(1, 3200, "DME", "AER", 180);
    private Ticket ticket2 = new Ticket(2, 5500, "DME", "LED", 200);
    private Ticket ticket3 = new Ticket(3, 2900, "DME", "AER", 1440);
    private Ticket ticket4 = new Ticket(1, 6000, "VKO", "OVB", 800);
    private Ticket ticket5 = new Ticket(1, 5000, "VKO", "OVB", 300);
    private Ticket ticket6 = new Ticket(1, 1000, "VKO", "OVB", 1000);
    private Ticket ticket7 = new Ticket(1, 50000, "VKO", "OVB", 180);
    private Ticket ticket8 = new Ticket(1, 7580, "VOZ", "LED", 180);
    private Ticket ticket9 = new Ticket(1, 15400, "VOZ", "LED", 120);
    private Ticket ticket10 = new Ticket(1, 6550, "VOZ", "LED", 240);


    @Test
    void findNullTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.findTicketSortedByPrice("VKO", "AER");

        assertArrayEquals(expected, actual);

    }

    @Test
    void findOneTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = manager.findTicketSortedByPrice("DME", "LED");

        assertArrayEquals(expected, actual);

    }

    @Test
    void findTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = new Ticket[]{ticket6, ticket5, ticket4, ticket7};
        Ticket[] actual = manager.findTicketSortedByPrice("VKO", "OVB");

        assertArrayEquals(expected, actual);

    }

    @Test
    void findAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = new Ticket[]{ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.findTicket("VKO", "OVB");

        assertArrayEquals(expected, actual);

    }
}