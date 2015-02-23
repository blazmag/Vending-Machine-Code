package com.magdic;

import com.magdic.currency.Coin;

import java.util.ArrayList;

/**
 * Helper utils for testing
 * Created by Blaz Magdic on 22.2.2015.
 */
public class TestUtils {

    /**
     * Iterates over an array of coins and sums their value.
     *
     * @param coins Array of coins.
     * @return Sum of all coins.
     */
    public static int sumCoinValues(ArrayList<Coin> coins) {
        int result = 0;
        for (Coin c : coins) {
            result += c.getValue();
        }
        return result;
    }
}
