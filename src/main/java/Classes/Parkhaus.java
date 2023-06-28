package Classes;

import java.time.LocalDateTime;

public class Parkhaus {
    /**
     * ALle benutzbaren Tickets
     */
    private static TicketDatenbank kompletteTicketDatenbank = new TicketDatenbank();

    /**
     * Alle Tickets, die sich gerade Im Parkhaus befinden
     */
    private static TicketDatenbank reingefahrenTicketDatenbank = new TicketDatenbank();

    /**
     * Alle normale Tickets, die nach dem Rausfahren für die Statisk gespeichert werden
     */
    private static TicketDatenbank umsatzTicketDatenbank = new TicketDatenbank();

    public static int time_offset = 0;
    private static int Parkplaetze = 50;
    private static int dauerparkerAnzahl = 0;

    private static Long gueltigKeitsLaengeDauerparker = 30L;

    public static TicketDatenbank getKompletteTicketDatenbank() {
        return kompletteTicketDatenbank;
    }

    public static void setKompletteTicketDatenbank(TicketDatenbank kompletteTicketDatenbank) {
        Parkhaus.kompletteTicketDatenbank = kompletteTicketDatenbank;
    }

    public static void reset() {
        kompletteTicketDatenbank = new TicketDatenbank();
    }

    public static int getParkplaetze() {
        return Parkplaetze;
    }

    public static int getOffizielFreieParkplaetze() {
        return Parkplaetze - Parkhaus.getDauerparkerAnzahl() - Autozaehler.getAutoanzahl();
    }

    public static int getInoffizielFreieParkplaetze() {
        return Parkplaetze - Autozaehler.getAutoanzahl();
    }

    public static void setParkplaetze(int parkplaetze) {
        Parkplaetze = parkplaetze;
    }

    public static void addTime_offset(int delta) {
        time_offset = time_offset + delta;
    }

    public static LocalDateTime getParkhausTime() {
        return addTime(LocalDateTime.now(), time_offset);
    }

    private static LocalDateTime addTime(LocalDateTime original, int delta) {
        LocalDateTime result = original;
        return result.plusMinutes(delta);
    }

    public static int getDauerparkerAnzahl() {
        return dauerparkerAnzahl;
    }

    public static void setDauerparkerAnzahl(int a) {
        dauerparkerAnzahl = a;
    }

    public static void erhoeheDauerparkerAnzahl() {
        dauerparkerAnzahl++;
    }

    public static void verringereDauerparkerAnzahl() {
        dauerparkerAnzahl++;
    }

    public static TicketDatenbank getReingefahrenTicketDatenbank() {
        return reingefahrenTicketDatenbank;
    }

    public static TicketDatenbank getUmsatzTicketDatenbank() {
        return umsatzTicketDatenbank;
    }

    public static Long getGueltigKeitsLaengeDauerparker() {
        return gueltigKeitsLaengeDauerparker;
    }

    public static void setGueltigKeitsLaengeDauerparker(Long gueltigKeitsLaengeDauerparker) {
        Parkhaus.gueltigKeitsLaengeDauerparker = gueltigKeitsLaengeDauerparker;
    }

    public static void removeAllTickets() {
        kompletteTicketDatenbank = new TicketDatenbank();
        reingefahrenTicketDatenbank = new TicketDatenbank();
        umsatzTicketDatenbank = new TicketDatenbank();
    }

}
