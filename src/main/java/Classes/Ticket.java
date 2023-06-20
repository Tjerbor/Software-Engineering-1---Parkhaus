package Classes;

import Classes.Ticketzustaende.Normalticket_Zustand;
import Interfaces.TicketIF;
import Interfaces.TicketZustandIF;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket implements TicketIF {
    protected TicketZustandIF ticketZustand;
    protected String ID;
    protected double ueberwiesen = 0.0;
    protected LocalDateTime erstellDatum = TicketDatenbank.getParkhausTime();
    protected LocalDateTime bezahlDatum;

    public Ticket() {
        this.ticketZustand = new Normalticket_Zustand(this);
    }

    @Override
    public String bezahlen() {
        return ticketZustand.bezahlen();
    }

    @Override
    public String rausfahren() {
        return ticketZustand.rausfahren();
    }

    @Override
    public String kassenautomatenText() {
        return ticketZustand.KassenautomatenText();
    }

    @Override
    public String informationen() {
        return ticketZustand.informationen();
    }

    /**
     * Berechnet die Parkdauer eines Tickets in Stunden.
     *
     * @return Parkdauer in Stunden
     */
    @Override
    public double berechneParkdauer() {
        LocalDateTime delta = Parkhaus.getTicketDatenbank().getParkhausTime();
        double stunden = (double) Duration.between(this.erstellDatum, delta).getSeconds();
        stunden /= 3600; //60*60 = 3600
        return stunden;
    }

    @Override
    public LocalDateTime getErstellDatum() {
        return erstellDatum;
    }


    @Override
    public LocalDateTime getBezahlDatum() {
        return bezahlDatum;
    }

    public String getID() {
        return ID;
    }

    public double getUeberwiesen() {
        return ueberwiesen;
    }

    public void setUeberwiesen(double ueberwiesen) {
        this.ueberwiesen = ueberwiesen;
    }

    public String getZustand() {
        return ticketZustand.getZustand();
    }

    public void setID(String id) {
        ID = id;
    }

    public void setTicketZustand(TicketZustandIF ticketZustand) {
        this.ticketZustand = ticketZustand;
    }

    public void setErstellDatum(LocalDateTime erstellDatum) {
        this.erstellDatum = erstellDatum;
    }

    public void setBezahlDatum(LocalDateTime bezahlDatum) {
        this.bezahlDatum = bezahlDatum;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketZustand=" + ticketZustand +
                ", ID='" + ID + '\'' +
                ", ueberwiesen=" + ueberwiesen +
                ", erstellDatum=" + erstellDatum +
                ", bezahlDatum=" + bezahlDatum +
                '}';
    }
}
