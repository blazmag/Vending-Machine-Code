package com.magdic;

import com.magdic.product.Product;
import com.magdic.product.ProductStock;

import java.util.HashMap;
import java.util.Map;

/**
 * Stock manager holds products and manages their stock levels.
 * Can be improved by allowing multiple stocking of a product with the same name.
 * Created by Blaz Magdic on 22.2.2015.
 */
public class StockManager {


    private Map<String, ProductStock> stock;

    public StockManager() {
        stock = new HashMap<String, ProductStock>();
    }

    /**
     * Stocks the supplied product. Increases product's stock level if the
     * product is already in stock, if not it adds it creates a new stock.
     *
     * @param product to add to stock.
     */
    public void addToStock(ProductStock product) {
        if (stock.containsKey(product.getName())) {
            ProductStock stockedProduct = findProduct(product);
            stockedProduct.increaseQuantity(product.getQuantity());
        } else {
            ProductStock duplicate = new ProductStock(product);
            stock.put(duplicate.getName(), duplicate);
        }
    }


    /**
     * Decreases the selected product stock if the product is found in the Vending machine.
     *
     * @param product Product whose stock will be decreased
     * @param amount  the amount of stock decreased
     */
    public void decreaseStock(Product product, int amount) {
        ProductStock productStock = findProduct(product);
        if (productStock != null) {
            productStock.decreaseQuantity(amount);
        }
    }

    /**
     * Looks for the current stock
     *
     * @param product
     * @return ProductStock containing Product data and stock information
     */
    public ProductStock findProduct(Product product) {
        if (stock.containsKey(product.getName())) {
            return stock.get(product.getName());
        }
        return null;
    }

    /**
     * Looks for a product and returns its stock level.
     *
     * @param product to look for.
     * @return stock level.
     */
    public int getCurrentStock(Product product) {
        ProductStock productStock = findProduct(product);
        if (productStock != null)
            return productStock.getQuantity();
        else
            return 0;
    }

    /**
     * Checks if a product has stock
     *
     * @param product
     * @return
     */
    public boolean hasStock(Product product) {
        return getCurrentStock(product) != 0;
    }

    /**
     * Checks if a product is being sold by this machine.
     *
     * @param product
     * @return
     */
    public boolean isProductSold(Product product) {
        if (stock.containsKey(product.getName()))
            return true;
        else return false;
    }

    /**
     * Get the amount of different products in the stock manager.
     *
     * @return
     */
    public int getProductCount() {
        return stock.size();
    }

}
