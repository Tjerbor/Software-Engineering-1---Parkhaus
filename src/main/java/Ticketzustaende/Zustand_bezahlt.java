package Ticketzustaende;

import Interfaces.Zustand;

public class Zustand_bezahlt implements Zustand {
    @Override
    public String getZustand() {
        return "bezahlt";
    }
}
