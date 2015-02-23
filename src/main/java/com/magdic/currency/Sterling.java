package com.magdic.currency;

/**
 * Implementation of the Pound sterling. For easier calculations the values are in pennies.
 * Can be improved by using Joda Money or BigDecimal.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class Sterling implements Currency {

    /**
     * Sterling symbol is £
     */
    public static String symbol = "£";


    public static final Coin PENNY = new Coin("Penny", 1, symbol);
    public static final Coin TWOPENCE = new Coin("Two pence", 2, symbol);
    public static final Coin FIVEPENCE = new Coin("Five pence", 5, symbol);
    public static final Coin TENPENCE = new Coin("Ten pence", 10, symbol);
    public static final Coin TWENTYPENCE = new Coin("Twenty pence", 20, symbol);
    public static final Coin FIFTYPENCE = new Coin("Fifty pence", 50, symbol);
    public static final Coin ONEPOUND = new Coin("One pound", 100, symbol);
    public static final Coin TWOPOUNDS = new Coin("Two pounds", 200, symbol);


    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Coin[] getDenominations() {
        return new Coin[]{TWOPOUNDS, ONEPOUND, FIFTYPENCE, TWENTYPENCE, TENPENCE, FIVEPENCE, TWOPENCE, PENNY};
    }
}
