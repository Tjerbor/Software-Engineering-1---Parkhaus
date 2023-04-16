import java.time.LocalDateTime;

public class Schranke {


    public boolean darfraus (Ticket ticket){
        LocalDateTime Abfahrtsdatum = LocalDateTime.now () ;
        if (ticket.isStatus()==false){
            System.out.println("Das Auto darf nicht rausfahren. Bitte bezahlen Sie zuerst.");
            return false ;
        }
        // Überprüfe, dass das Abfahrtsdatum nicht mehr als 30 Minuten nach dem Bezahldatum liegt wenn nicht dann tauche den status und die Zeit aus!
        if ((Abfahrtsdatum.minusMinutes(30).isBefore( ticket.getBezahldatum())) ==true) {
            return true; }
    else {System.out.println("Das Auto darf nicht rausfahren da sie vor mehr als 30 Minuten bezahlt haben. Bitte bezahlen Sie zuerst.");
        ticket.setStatus(false);
        ticket.setEingangsdatum(ticket.getBezahldatum());
        return false ;
    }
    }

}
