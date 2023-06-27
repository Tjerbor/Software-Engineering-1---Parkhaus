package Exceptions;

import java.rmi.ServerException;

public class RaumZeitKontinuumException extends ServerException {

    public RaumZeitKontinuumException() {
        super("Raum-Zeit-Kontinuum verletzt.");
    }

}
