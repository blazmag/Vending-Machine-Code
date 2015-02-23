package com.magdic;

import com.magdic.currency.Coin;
import com.magdic.currency.Currency;
import com.magdic.exception.InvalidCurrencyException;

import java.util.ArrayList;

/**
 * Symbolizes the coin insert slot and dispensing mechanism in the vending machine.
 * Takes Coins of accepted currency and updates the current credit value.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class CoinContainer {


    private Currency acceptedCurrency;
    private int currentValue;

    /**
     * Only allows one accepted currency. Could be improved by allowing multiple
     * currencies.
     *
     * @param acceptedCurrency
     */
    public CoinContainer(Currency acceptedCurrency) {
        this.acceptedCurrency = acceptedCurrency;
    }

    /**
     * @return Returns the accepted currency
     */
    public Currency getAcceptedCurrency() {
        return acceptedCurrency;
    }


    /**
     * Consumes the coin and adds it to the current credit.
     *
     * @param coin
     */
    public void insertCoin(Coin coin) {

        if (!coin.getSymbol().equals(acceptedCurrency.getSymbol()))
            throw new InvalidCurrencyException(coin.getSymbol());

        currentValue += coin.getValue();
    }

    /**
     * Current sum value of all inserted coins
     *
     * @return
     */
    public int getCurrentCredit() {
        return currentValue;
    }


    /**
     * Calculate the amount of returned coins by using accepted currency
     * denominations
     *
     * @return List of returned coins of appropriate denominations
     */
    public ArrayList<Coin> dispenseCoins() {
        Coin[] denominations = acceptedCurrency.getDenominations();
        ArrayList<Coin> change = new ArrayList<Coin>();
        for (Coin denomination : denominations) {
            if (currentValue / denomination.getValue() >= 1) {
                //calculate how many coins of this denomination are in the change
                int numberOfCoins = (int) (currentValue / denomination.getValue());
                //remove the coins from change
                currentValue -= (numberOfCoins * denomination.getValue());
                change.add(denomination);
            }
        }
        return change;
    }

    /**
     * Consumes specified amount by decreasing the current credit value
     *
     * @param amount in pennies
     */
    public void consumeCredit(int amount) {
        currentValue -= amount;
    }
}
