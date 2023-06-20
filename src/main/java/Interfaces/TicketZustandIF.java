package Interfaces;

import Classes.Tickets.Ticket;

public interface TicketZustandIF {
    public String KassenautomatenText();

    public String bezahlen();

    public String reinfahren();

    public String rausfahren();

    public String informationen();

    public Ticket getParent();

    public String getZustand();
}
