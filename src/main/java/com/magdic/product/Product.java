package com.magdic.product;

/**
 * Basic vending item dispensed by the Vending Machine
 * Created by Blaz Magdic on 22.2.2015.
 */
public class Product {

    private String name;
    private int price;


    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the name of the product
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the price of the product in pennies
     *
     * @return price in pennies
     */
    public int getPrice() {
        return price;
    }


}
