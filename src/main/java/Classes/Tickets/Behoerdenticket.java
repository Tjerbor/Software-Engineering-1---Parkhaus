package Classes.Tickets;

import Classes.Ticketzustaende.Behoerdenticket_Zustand;

public class Behoerdenticket extends Ticket {
    public Behoerdenticket() {
        ticketZustand = new Behoerdenticket_Zustand(this);
    }
}