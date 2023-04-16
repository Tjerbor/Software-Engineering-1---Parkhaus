import java.time.LocalDateTime;

public class Autozaehler {

    public void bezahlen (Ticket ticket, double uberwiesenesumme){
        //zu Bezahlender Betrag kalkulieren
        Preis preis = new Preis();
        double ticketpreis = preis.getPreis (ticket.getEingangsdatum(), LocalDateTime.now ());
        // Überprüfe, ob die überwiesene Summe dem Sollbetrag gleicht(vergleich mit Toleranzbereich von 0.0001)
        if(uberwiesenesumme -ticketpreis > -0.0001  ){
        ticket.setBezahldatum(LocalDateTime.now ());
        ticket.setStatus(true);}
        else {
        System.out.println("Die überwiesene Summe ist geringer als der Sollbetrag.");
        }
     }


}
