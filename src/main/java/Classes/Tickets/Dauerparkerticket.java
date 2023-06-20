package Classes.Tickets;

public class Dauerparkerticket extends Ticket {
//    private static final int PARKDAUER_MONATE = 1;
//
//    public Dauerparkerticket() {
//        super();
//    }
//
//    public Dauerparkerticket(String id) {
//        super("DP"+ id);
//    }
//
//    public Dauerparkerticket(boolean ersatzTicket) {
//        super(ersatzTicket);
//    }
//
//    @Override
//    public double berechneParkdauer() {
//        if (getBezahlDatum() != null) {
//            LocalDateTime aktuellesDatum = Parkhaus.getTicketDatenbank().getParkhausTime();
//            Duration parkdauer = Duration.between(getBezahlDatum(), aktuellesDatum);
//            long monate = parkdauer.toDays() / 30;
//            return monate > PARKDAUER_MONATE ? PARKDAUER_MONATE : monate;
//        }
//        return 0.0;
//    }
//
//    @Override
//    public String toString() {
//        return "Dauerparkerticket{" +
//                "ID='" + getID() + '\'' +
//                ", ueberwiesen=" + getUeberwiesen() +
//                ", ersatzTicket=" + isErsatzTicket() +
//                ", erstellDatum=" + getErstellDatum() +
//                ", bezahlDatum=" + getBezahlDatum() +
//                '}';
//    }
}