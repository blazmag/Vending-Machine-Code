package com.magdic.exception;

/**
 * Thrown when a product is requested that is not in stock.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class NotInStockException extends RuntimeException {

    public NotInStockException(String name) {
        super("Product:" + name + " is not in stock!");
    }
}
