package Classes.Tickets;

import Classes.Ticketzustaende.Ersatzticket_Zustand;

public class Ersatzticket extends Ticket {
    public Ersatzticket() {
        ticketZustand = new Ersatzticket_Zustand(this);
    }
}
