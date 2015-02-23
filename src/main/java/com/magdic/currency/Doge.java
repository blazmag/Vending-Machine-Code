package com.magdic.currency;

/**
 * Test example implementation of DOGE cryptocurrency to show
 * InvalidCurrencyException.
 * <p/>
 * Created by Developer on 20.2.2015.
 */
public class Doge implements Currency {

    /**
     * DOGE symbol is Đ
     */
    public static String symbol = "Ð";

    public static final Coin ONEDOGE = new Coin("One DOGE", 1, symbol);

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Coin[] getDenominations() {
        return new Coin[]{ONEDOGE};
    }
}
