package Classes;

import Classes.Rausfahren;
import Classes.Tickets.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RausfahrenTest {

    @Test
    public void testDarfRaus_ticketIDStartsWith110_shouldReturnTrue() {
        // Arrange
        Rausfahren rausfahren = new Rausfahren();
        Ticket ticket = new Ticket();
        ticket.setID("110123");

        // Act
        boolean result = rausfahren.darfraus(ticket);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testDarfRaus_ticketIDStartsWithDPAndBezahlDatumNotNull_shouldReturnTrue() {
        // Arrange
        Rausfahren rausfahren = new Rausfahren();
        Ticket ticket = new Ticket();
        ticket.setID("DP123");
        ticket.setBezahlDatum(LocalDateTime.now());

        // Act
        boolean result = rausfahren.darfraus(ticket);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testDarfRaus_bezahlDatumWithin15Minutes_shouldReturnTrue() {
        // Arrange
        Rausfahren rausfahren = new Rausfahren();
        Ticket ticket = new Ticket();
        ticket.setID("ABC123");
        ticket.setErstellDatum(LocalDateTime.now().minusMinutes(5));
        ticket.setBezahlDatum(LocalDateTime.now());

        // Act
        boolean result = rausfahren.darfraus(ticket);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testDarfRaus_defaultCase_shouldReturnFalse() {
        // Arrange
        Rausfahren rausfahren = new Rausfahren();
        Ticket ticket = new Ticket();
        ticket.setID("XYZ123");
        ticket.setBezahlDatum(Parkhaus.getParkhausTime().minusMinutes(20));

        // Act
        boolean result = rausfahren.darfraus(ticket);

        // Assert
        Assertions.assertFalse(result);
    }
}
