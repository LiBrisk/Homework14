package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class AviaSoulsTest {

    @Test
    public void testShouldSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("VLG", "KRD", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("VLG", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("VLG", "KRD", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("VLG", "KRD", 9000, 7, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "KRD");

        Ticket[] expected = {ticket3, ticket1, ticket5, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldFindOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("VLG", "KRD", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("SPB", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("VLG", "SPB", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("VLG", "SPB", 9000, 7, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "KRD");
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testShouldFindZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "KRD", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("SPB", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("EKB", "SPB", 9000, 7, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "KRD");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testShouldSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("VLG", "KRD", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("VLG", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("VLG", "KRD", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("VLG", "KRD", 9000, 6, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("VLG", "KRD", comparator);
        Ticket[] expected = {ticket3, ticket1, ticket7, ticket5};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testShouldFindOneTicketComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("VLG", "KRD", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("SPB", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("VLG", "SPB", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("VLG", "SPB", 9000, 7, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("VLG", "KRD", comparator);
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testShouldFindZeroTicketComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("VLG", "MSK", 4000, 8, 10);
        Ticket ticket2 = new Ticket("KRD", "MSK", 3000, 11, 13);
        Ticket ticket3 = new Ticket("SPB", "KRD", 2000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "VLG", 5000, 12, 14);
        Ticket ticket5 = new Ticket("VLG", "SPB", 8000, 6, 11);
        Ticket ticket6 = new Ticket("EKB", "SPB", 7000, 5, 10);
        Ticket ticket7 = new Ticket("VLG", "SPB", 9000, 7, 9);
        Ticket ticket8 = new Ticket("RND", "KRD", 1000, 12, 13);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("VLG", "KRD", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);


    }

}
