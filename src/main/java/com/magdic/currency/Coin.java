package com.magdic.currency;

/**
 * Represents a coin used by the vending machine in the selected currency.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class Coin {


    private String name;
    private int value;
    private String symbol;

    /**
     * Constructs a new Coin
     *
     * @param name   Typical coin denomination name.
     * @param value  Coin denomination value in pennies.
     * @param symbol Currency symbol.
     */
    public Coin(String name, int value, String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }

    /**
     * Get the typical coin denomination name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the coin symbol
     *
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Get the coin value in pennies
     *
     * @return value in pennies
     */
    public int getValue() {
        return value;
    }

}
