package com.magdic.currency;

/**
 * Created by Blaz Magdic on 22.2.2015.
 */
public interface Currency {
    /**
     * A symbol typically associated with the currency.
     *
     * @return String containing the currency symbol.
     */
    String getSymbol();


    /**
     * An array of legal coin denominations for the currency
     *
     * @return Array of denomination coins
     */
    Coin[] getDenominations();
}


