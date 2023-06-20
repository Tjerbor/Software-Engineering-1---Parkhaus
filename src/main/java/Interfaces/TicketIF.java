package Interfaces;

import java.time.LocalDateTime;

public interface TicketIF {
    double berechneParkdauer();

    LocalDateTime getErstellDatum();

    LocalDateTime getBezahlDatum();

    public String kassenautomatenText();

    public String bezahlen();

    public String reinfahren();

    public String rausfahren();

    public String informationen();
}
