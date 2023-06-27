package Classes;

import Exceptions.RaumZeitKontinuumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Tickets.Dauerparkerticket;
import Classes.Ticketzustaende.Dauerparker_Zustand;
import Classes.Parkhaus;

import static org.junit.jupiter.api.Assertions.*;

class DauerparkerticketTest {

    private Dauerparkerticket dauerparkerticket;

    @BeforeEach
    void setUp() {
        dauerparkerticket = new Dauerparkerticket();
    }

    @Test
    void testInit() throws RaumZeitKontinuumException {
        // Leere die Ticket-Datenbank vor jedem Test
        Parkhaus.getKompletteTicketDatenbank().bereinigeDatenbank();

        dauerparkerticket.init();

        // Überprüfe, ob das Ticket zur Ticket-Datenbank hinzugefügt wurde
        assertTrue(Parkhaus.getKompletteTicketDatenbank().containsTicket(dauerparkerticket.getID()));

       ;
    };

    @Test
    void testGetTicketZustand() {
        assertNotNull(dauerparkerticket.getZustand());
    }



}
