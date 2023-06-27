package Classes;

import Classes.Parkhaus;
import Classes.Tickets.Ersatzticket;
import Classes.Ticketzustaende.Ersatzticket_Zustand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ErsatzticketTest {

    private Ersatzticket ersatzticket;

    @BeforeEach
    public void setUp() {
        Parkhaus.reset(); // Zurücksetzen der Ticket-Datenbank für den Test
        ersatzticket = new Ersatzticket();
    }

    @Test
    public void testInit() {
        ersatzticket.init();

        assertNotNull(ersatzticket.getZustand()); // Überprüfen, ob der Zustand des Tickets initialisiert wurde

        // Überprüfen, ob das Ticket in beiden Ticket-Datenbanken hinzugefügt wurde
        assertEquals(1, Parkhaus.getKompletteTicketDatenbank().getTicketanzahl());
        assertEquals(1, Parkhaus.getReingefahrenTicketDatenbank().getTicketanzahl());
    }
}
