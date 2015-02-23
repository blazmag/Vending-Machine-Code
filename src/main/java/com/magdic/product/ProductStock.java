package com.magdic.product;

/**
 * Product with stock information in the Vending machine.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class ProductStock extends Product {

    private int quantity;

    public ProductStock(String name, int price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public ProductStock(ProductStock original) {
        super(original.getName(), original.getPrice());
        this.quantity = original.getQuantity();
    }

    /**
     * Get the product stock quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the product stock quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Increase the product stock quantity by the specified amount
     *
     * @param amount
     */
    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    /**
     * Decrease the product stock quantity by the specified amount
     *
     * @param amount
     */
    public void decreaseQuantity(int amount) {
        quantity -= amount;
    }


}
