import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {

    private boolean bezahlt = false;
    private boolean ersatzTicket = false;
    private LocalDateTime erstellDatum;
    private LocalDateTime bezahlDatum;

    public Ticket() {
        this.erstellDatum = LocalDateTime.now();
        Autozaehler.erhoeheAnzahl();
    }

    public Ticket(boolean ersatzTicket) {
        if (ersatzTicket) {
            erstellDatum = LocalDateTime.now().minusHours(24); //Garantiert Tagespreis fürs Ticket
            ersatzTicket = true;
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
    public double berechneParkdauer() {
        LocalDateTime delta = LocalDateTime.now();
        double stunden = (double) Duration.between(this.erstellDatum, delta).getSeconds();
        stunden /= 3600; //60*60 = 3600
        return stunden;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public boolean isErsatzTicket() {
        return ersatzTicket;
    }

    public LocalDateTime getErstellDatum() {
        return erstellDatum;
    }

    public LocalDateTime getBezahlDatum() {
        return bezahlDatum;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
        if (bezahlt) {
            this.bezahlDatum = LocalDateTime.now();
        } else {
            this.bezahlDatum = null;
        }
    }
}
