package com.magdic;

import com.magdic.currency.Coin;
import com.magdic.product.Product;

import java.util.ArrayList;

/**
 * Interface for interaction with the Vending Machine.
 * Examples of implementation can be console printouts, actual
 * interaction with hardware layers, test calls, etc.
 * Created by Blaz Magdic on 22.2.2015.
 */
public interface VendingInterface {
    void ejectCredit(ArrayList<Coin> credit);

    /**
     * Dispenses the currently selected product
     *
     * @param product Dispensed product
     */
    void dispenseProduct(Product product);

    /**
     * Show the price of currently selected product.
     *
     * @param price Price of currently selected product. NOTE: is in pennies.
     */
    void showPrice(int price);

    /**
     * Show the current sum value of inserted coins.
     *
     * @param credit Current sum value of inserted coins.
     */
    void showCredit(int credit);

    /**
     * Show the quantity of currently selected product.
     *
     * @param quantity Quantity of currently selected product.
     */
    void showStockForProduct(int quantity);
}
