package com.treasure.hunt.treasurehunt.exception;

/**
 * Exception class when treasure not found.
 */
public class TreasureNotFoundException extends RuntimeException {
    public TreasureNotFoundException(String message) {
        super(message);
    }
}
