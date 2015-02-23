package com.magdic;

import com.magdic.currency.Coin;
import com.magdic.currency.Currency;
import com.magdic.exception.InvalidProductException;
import com.magdic.exception.NotInStockException;
import com.magdic.product.Product;
import com.magdic.product.ProductStock;

import java.util.ArrayList;

/**
 * Vending machine implementation with stock management and coin dispensing.
 * Uses @link com.magdic.StockManager to handle stocking of products.
 * <p/>
 * Created by Blaz Magdic on 22.2.2015.
 */
public class VendingMachine {

    private StockManager stockManager;
    private CoinContainer coinContainer;
    private Currency acceptedCurrency;
    private VendingInterface machineUI;

    /**
     * Initializes the vending machine with accepted currency and selected interface.
     */
    public VendingMachine(VendingInterface ui, Currency currency) {
        machineUI = ui;
        acceptedCurrency = currency;
        stockManager = new StockManager();
        coinContainer = new CoinContainer(acceptedCurrency);
    }

    /**
     * Performs purchase of the selected product.
     * Throws {@link com.magdic.exception.NotInStockException} if there is no stock for
     * the selected product or throws {@link com.magdic.exception.InvalidProductException} if
     * the product is invalid.
     *
     * @param product selected product
     */
    public void performPurchase(Product product) {
        if (!stockManager.isProductSold(product))
            throw new InvalidProductException(product.getName());
        if (!stockManager.hasStock(product))
            throw new NotInStockException(product.getName());

        ProductStock stockedProduct = stockManager.findProduct(product);

        //check if we have enough credit  for product
        if (coinContainer.getCurrentCredit() >= stockedProduct.getPrice()) {
            //dispense the product
            stockManager.decreaseStock(stockedProduct, 1);
            machineUI.showStockForProduct(stockedProduct.getQuantity());
            dispenseProduct(stockedProduct);
            //deduct product price from inserted credit
            coinContainer.consumeCredit(stockedProduct.getPrice());
            //update display with  credit left
            machineUI.showCredit(coinContainer.getCurrentCredit());
        } else {
            //not enough credit, show product price
            machineUI.showPrice(stockedProduct.getPrice());
        }
    }

    /**
     * Looks for product stock and tries to increase it. If there is no stock for
     * the product, it creates a new stock entry.
     *
     * @param product the product whose stock levels will be increased
     */
    public void addStock(ProductStock product) {
        //adds product to stock
        stockManager.addToStock(product);
        ProductStock stockedProduct = stockManager.findProduct(product);
        machineUI.showStockForProduct(stockedProduct.getQuantity());
    }

    private void dispenseProduct(Product product) {
        machineUI.dispenseProduct(product);
    }

    /**
     * Adds a coin to the coin container.
     *
     * @param coin Coin to be added to the container
     */
    public void addCoin(Coin coin) {
        coinContainer.insertCoin(coin);
        machineUI.showCredit(coinContainer.getCurrentCredit());
    }

    /**
     * Dispenses credit with appropriate coin denominations by notifying the UI interface
     */
    public void ejectCoins() {
        ArrayList<Coin> coins = coinContainer.dispenseCoins();
        machineUI.ejectCredit(coins);
    }
}
