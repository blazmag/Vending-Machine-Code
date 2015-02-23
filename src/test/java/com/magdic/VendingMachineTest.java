package com.magdic;

import com.magdic.currency.Coin;
import com.magdic.currency.Doge;
import com.magdic.currency.Sterling;
import com.magdic.exception.InvalidCurrencyException;
import com.magdic.exception.InvalidProductException;
import com.magdic.exception.NotInStockException;
import com.magdic.product.Product;
import com.magdic.product.ProductStock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Vending machine unit test for jUnit4
 * Created by Blaz Magdic on 22.2.2015.
 */
public class VendingMachineTest {

    //products for stocking
    final ProductStock COCACOLA = new ProductStock("Coca Cola", 99, 5);
    final ProductStock SNICKERS = new ProductStock("Snickers", 150, 5);
    final ProductStock WATER = new ProductStock("Water", 50, 0);

    private VendingMachine vendingMachine;
    private TestInterface testUI;

    @Before
    public void executedBeforeEach() {
        testUI = new TestInterface();
        vendingMachine = new VendingMachine(testUI, new Sterling());
        vendingMachine.addStock(COCACOLA);
        vendingMachine.addStock(SNICKERS);
        vendingMachine.addStock(WATER);
    }


    @Test(expected = NotInStockException.class)
    public void testSelectProductNotInStock() {
        vendingMachine.performPurchase(WATER);
    }


    @Test(expected = InvalidProductException.class)
    public void testSelectInvalidProduct() {

        Product NEXUS5 = new Product("Nexus 5 phone", 20000);
        vendingMachine.performPurchase(NEXUS5);
    }

    @Test(expected = InvalidCurrencyException.class)
    public void testInsertInvalidCoin() {
        vendingMachine.addCoin(Doge.ONEDOGE);
    }

    @Test
    public void testOverpaymentKeepsCorrectCredits() {
        vendingMachine.addCoin(Sterling.ONEPOUND);
        vendingMachine.performPurchase(COCACOLA);
        assertEquals(1, testUI.creditShown);
    }

    @Test
    public void testCorrectCreditAccumulation() {
        vendingMachine.addCoin(Sterling.TENPENCE);
        vendingMachine.addCoin(Sterling.FIFTYPENCE);
        vendingMachine.addCoin(Sterling.PENNY);
        assertEquals(61, testUI.creditShown);
    }

    @Test
    public void testStockDecreaseAfterPurchase() {
        vendingMachine.addCoin(Sterling.FIFTYPENCE);
        vendingMachine.addCoin(Sterling.ONEPOUND);

        vendingMachine.performPurchase(SNICKERS);


        assertEquals(4, testUI.stockForProduct);
    }

    @Test
    public void testSterlingCoinsSumUtil() {
        ArrayList<Coin> coins = new ArrayList<Coin>();
        coins.add(Sterling.PENNY);
        coins.add(Sterling.TWOPENCE);
        coins.add(Sterling.FIVEPENCE);
        coins.add(Sterling.TENPENCE);
        coins.add(Sterling.TWENTYPENCE);
        coins.add(Sterling.FIFTYPENCE);
        coins.add(Sterling.ONEPOUND);
        coins.add(Sterling.TWOPOUNDS);


        assertEquals(388, TestUtils.sumCoinValues(coins));
    }

    @Test
    public void testCorrectStockAfterRestock() {
        vendingMachine.addCoin(Sterling.TWOPOUNDS);
        vendingMachine.addCoin(Sterling.TWOPOUNDS);
        vendingMachine.addCoin(Sterling.TWOPOUNDS);
        vendingMachine.addCoin(Sterling.TWOPOUNDS);
        vendingMachine.addCoin(Sterling.TWOPOUNDS);

        vendingMachine.performPurchase(SNICKERS);
        vendingMachine.performPurchase(SNICKERS);
        vendingMachine.performPurchase(SNICKERS);
        vendingMachine.performPurchase(SNICKERS);
        vendingMachine.performPurchase(SNICKERS);

        SNICKERS.setQuantity(3);

        vendingMachine.addStock(SNICKERS);

        assertEquals(3, testUI.stockForProduct);
    }

    @Test
    public void testCorrectChangeIfEjectBeforePurchase() {
        vendingMachine.addCoin(Sterling.TENPENCE);
        vendingMachine.addCoin(Sterling.FIFTYPENCE);
        vendingMachine.addCoin(Sterling.PENNY);
        vendingMachine.addCoin(Sterling.ONEPOUND);

        vendingMachine.ejectCoins();
        int changeValue = TestUtils.sumCoinValues(testUI.creditReturned);

        assertEquals(161, changeValue);
    }

    @Test
    public void testCorrectChangeGiven() {
        vendingMachine.addCoin(Sterling.ONEPOUND);
        vendingMachine.addCoin(Sterling.FIFTYPENCE);
        vendingMachine.addCoin(Sterling.FIFTYPENCE);

        vendingMachine.performPurchase(SNICKERS);
        vendingMachine.ejectCoins();

        int changeValue = TestUtils.sumCoinValues(testUI.creditReturned);

        assertEquals(50, changeValue);
    }

    @Test
    public void testNotEnoughCreditForPurchase() {
        vendingMachine.addCoin(Sterling.TWENTYPENCE);
        vendingMachine.addCoin(Sterling.TWENTYPENCE);

        vendingMachine.performPurchase(SNICKERS);

        assertEquals(SNICKERS.getPrice(), testUI.priceShown);
    }


}
