package Classes.Ticketzustaende;

import Interfaces.Zustand;

public class Zustand_Nachzahlung implements Zustand {
    @Override
    public String getZustand() {
        return "Nachzahlung";
    }
}
