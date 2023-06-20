package Interfaces;

import Classes.Ticket;

public interface TicketZustandIF {
    public String KassenautomatenText();

    public String bezahlen();

    public String rausfahren();

    public String informationen();

    public Ticket getParent();

    public String getZustand();
}
