package Classes.Tickets;

import Classes.Parkhaus;
import Classes.Ticketzustaende.Ersatzticket_Zustand;

public class Ersatzticket extends Ticket {
    public Ersatzticket() {

    }

    @Override
    public void init() {
        Parkhaus.getKompletteTicketDatenbank().addticket(this);
        Parkhaus.getReingefahrenTicketDatenbank().addticket(this);
        ticketZustand = new Ersatzticket_Zustand(this);
    }
}
