package Classes;

import Interfaces.TicketIF;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket implements TicketIF {

    private final String ID;
    private boolean bezahlt = false;
    private boolean ersatzTicket = false;
    private LocalDateTime erstellDatum;
    private LocalDateTime bezahlDatum;

    public Ticket() {
        this(false);
    }

    public Ticket(boolean ersatzTicket) {
        this.ID = UUID.randomUUID().toString();
        if (ersatzTicket) {
            this.erstellDatum = LocalDateTime.now().minusHours(24); //Garantiert Tagespreis fürs Ticket
            this.ersatzTicket = true;
        } else {
            this.erstellDatum = LocalDateTime.now();
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
        LocalDateTime delta = LocalDateTime.now();
        double stunden = (double) Duration.between(this.erstellDatum, delta).getSeconds();
        stunden /= 3600; //60*60 = 3600
        return stunden;
    }

    @Override
    public boolean isBezahlt() {
        return bezahlt;
    }

    @Override
    public boolean isErsatzTicket() {
        return ersatzTicket;
    }

    @Override
    public LocalDateTime getErstellDatum() {
        return erstellDatum;
    }

    public void setErstellDatum(LocalDateTime erstellDatum) {
        this.erstellDatum = erstellDatum;
    }

    @Override
    public LocalDateTime getBezahlDatum() {
        return bezahlDatum;
    }

    public String getID() {
        return ID;
    }

    @Override
    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
        if (bezahlt) {
            this.bezahlDatum = LocalDateTime.now();
        } else {
            this.bezahlDatum = null;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID='" + ID + '\'' +
                ", bezahlt=" + bezahlt +
                ", ersatzTicket=" + ersatzTicket +
                ", erstellDatum=" + erstellDatum +
                ", bezahlDatum=" + bezahlDatum +
                '}';
    }
}
