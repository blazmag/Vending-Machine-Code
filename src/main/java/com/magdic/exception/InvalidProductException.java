package com.magdic.exception;

/**
 * Thrown when a product is requested that is not sold by the Vending machine.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class InvalidProductException extends RuntimeException {

    public InvalidProductException(String name) {
        super("Product: " + name + " is not sold by this machine!");
    }
}
