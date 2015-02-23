package com.magdic.exception;

/**
 * Thrown when a coin of invalid currency is inserted into the Coin container
 * <p/>
 * Created by Blaz Magdic on 22.2.2015.
 */
public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException(String currency) {
        super("Only " + currency + " currency supported!");
    }
}
