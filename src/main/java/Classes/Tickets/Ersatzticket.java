package Classes.Tickets;

import Classes.Ticketzustaende.Ersatzticket_Zustand;

public class Ersatzticket extends Ticket {
    public Ersatzticket() {

    }

    @Override
    public void init() {
        ticketZustand = new Ersatzticket_Zustand(this);
    }
}
