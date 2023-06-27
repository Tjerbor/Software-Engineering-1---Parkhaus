package Classes;

import Classes.Tickets.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatistikTest {

    private TicketDatenbank umsatzTicketDatenbank;

    @BeforeEach
    void setUp() {
        // Erstellen von Mock-Objekten für die Abhängigkeiten
        Parkhaus parkhaus = new Parkhaus();
        umsatzTicketDatenbank = new TicketDatenbank();

    }

    @Test
    void testBerechneEinnahmen() {
        // Erstellen der Testdaten
        LocalDateTime start = LocalDateTime.of(2023, 6, 1, 0, 0); // Startzeitpunkt des Testzeitraums
        LocalDateTime end = LocalDateTime.of(2023, 6, 30, 23, 59); // Endzeitpunkt des Testzeitraums

        // Erstellen von Test-Tickets und Hinzufügen zur Umsatz-Ticket-Datenbank
        Ticket ticket1 = new Ticket();
        ticket1.setBezahlDatum(LocalDateTime.of(2023, 6, 10, 12, 0)); // Beispielhaftes Bezahlungsdatum innerhalb des Testzeitraums
        ticket1.setUeberwiesen(0.0);
        umsatzTicketDatenbank.addticket(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setBezahlDatum(LocalDateTime.of(2023, 5, 1, 10, 0)); // Beispielhaftes Bezahlungsdatum außerhalb des Testzeitraums
        ticket2.setUeberwiesen(0.0);
        umsatzTicketDatenbank.addticket(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setBezahlDatum(LocalDateTime.of(2023, 6, 20, 15, 30)); // Beispielhaftes Bezahlungsdatum innerhalb des Testzeitraums
        ticket3.setUeberwiesen(0.0);
        umsatzTicketDatenbank.addticket(ticket3);

        // Erwartetes Ergebnis berechnen
        double parkdauer1 = ticket1.berechneParkdauer();
        double stundenpreis = Preis.getStundenpreis(); // Ersetzen Sie dies durch Ihren tatsächlichen Stundenpreis
        double erwarteteEinnahmen1 = parkdauer1 * stundenpreis;

        double parkdauer2 = ticket3.berechneParkdauer();
        double erwarteteEinnahmen2 = parkdauer2 * stundenpreis;

        // Testen der Methode berechneEinnahmen()
        double tatsächlicheEinnahmen = Statistik.berechneEinnahmen(start, end);

        // Überprüfen, ob das erwartete Ergebnis mit dem tatsächlichen Ergebnis übereinstimmt
        assertEquals(erwarteteEinnahmen1 + erwarteteEinnahmen2, tatsächlicheEinnahmen, 0.01); // Verwenden Sie einen Toleranzwert entsprechend Ihrer Anforderungen
    }

    @Test
    void testBerechneEinnahmenKeineBezahlungen() {
        // Erstellen der Testdaten
        LocalDateTime start = LocalDateTime.of(2023, 6, 1, 0, 0); // Startzeitpunkt des Testzeitraums
        LocalDateTime end = LocalDateTime.of(2023, 6, 30, 23, 59); // Endzeitpunkt des Testzeitraums

        // Testen der Methode berechneEinnahmen() ohne vorhandene Bezahlungen
        double tatsächlicheEinnahmen = Statistik.berechneEinnahmen(start, end);

        // Überprüfen, ob das erwartete Ergebnis mit dem tatsächlichen Ergebnis übereinstimmt (0 Einnahmen)
        assertEquals(0.0, tatsächlicheEinnahmen, 0.01); // Verwenden Sie einen Toleranzwert entsprechend Ihrer Anforderungen
    }
}
