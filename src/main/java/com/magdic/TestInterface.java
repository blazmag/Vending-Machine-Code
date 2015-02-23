package com.magdic;

import com.magdic.currency.Coin;
import com.magdic.product.Product;

import java.util.ArrayList;

/**
 * Created by Blaz Magdic on 22.2.2015.
 */
public class TestInterface implements VendingInterface {


    public int priceShown;
    public int creditShown;
    public Product dispensedProduct;
    public ArrayList<Coin> creditReturned;
    public int stockForProduct;


    @Override
    public void ejectCredit(ArrayList<Coin> credit) {
        creditReturned = credit;
    }

    @Override
    public void dispenseProduct(Product product) {
        dispensedProduct = product;
    }

    @Override
    public void showPrice(int price) {
        priceShown = price;
    }

    @Override
    public void showCredit(int credit) {
        creditShown = credit;
    }

    @Override
    public void showStockForProduct(int quantity) {
        stockForProduct = quantity;
    }
}
