package Classes;

import Exceptions.RaumZeitKontinuumException;
import Interfaces.TicketIF;
import Interfaces.Zustand;
import Classes.Ticketzustaende.Zustand_Nachzahlung;
import Classes.Ticketzustaende.Zustand_bezahlt;
import Classes.Ticketzustaende.Zustand_erstellt;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket implements TicketIF {
    private Zustand zustand = new Zustand_erstellt();

    private final String ID;
    private double ueberwiesen = 0.0;
    private boolean ersatzTicket = false;
    private LocalDateTime erstellDatum = TicketDatenbank.getParkhausTime();
    private LocalDateTime bezahlDatum;

    public Ticket() {
        this(false);
    }

    public Ticket(String id) {
        ID = id;
        this.erstellDatum = Parkhaus.getTicketDatenbank().getParkhausTime();
        Autozaehler.erhoeheAnzahl();
    }

    public Ticket(boolean ersatzTicket) {
        this.ID = UUID.randomUUID().toString();
        if (ersatzTicket) {
            this.erstellDatum = Parkhaus.getTicketDatenbank().getParkhausTime().minusHours(24); //Garantiert Tagespreis fürs Ticket
            this.ersatzTicket = true;
        } else {
            this.erstellDatum = Parkhaus.getTicketDatenbank().getParkhausTime();
            Autozaehler.erhoeheAnzahl();
        }
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
    public boolean isErsatzTicket() {
        return ersatzTicket;
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
        return zustand.getZustand();
    }

    public void changeZustand(String zustand) {
        if (zustand.equals("erstellt")) {
            this.zustand = new Zustand_erstellt();
            this.ueberwiesen = 0.0;
            this.erstellDatum = TicketDatenbank.getParkhausTime();
            this.bezahlDatum = null;
        } else if (zustand.equals("bezahlt")) {
            this.zustand = new Zustand_bezahlt();
            this.bezahlDatum = TicketDatenbank.getParkhausTime();
        } else if (zustand.equals("Nachzahlung")) {
            this.zustand = new Zustand_Nachzahlung();
            this.bezahlDatum = null;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "zustand=" + zustand +
                ", ID='" + ID + '\'' +
                ", ueberwiesen=" + ueberwiesen +
                ", ersatzTicket=" + ersatzTicket +
                ", erstellDatum=" + erstellDatum +
                ", bezahlDatum=" + bezahlDatum +
                '}';
    }
}
