package Classes.Ticketzustaende;

import Interfaces.Zustand;

public class Zustand_erstellt implements Zustand {
    @Override
    public String getZustand() {
        return "erstellt";
    }
}
