package by.epam.lab.tests;

import by.epam.lab.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseUtilTest {
    @Test
    public void binarySearchTest() {
        Product product = new Product("Milk", new Byn(500));
        AbstractPurchase key = new PriceDiscountPurchase(product, 1, new Byn());
        AbstractPurchase purchaseOne = new PriceDiscountPurchase(product, 1, new Byn(100));
        AbstractPurchase purchaseTwo = new PriceDiscountPurchase(product, 1, new Byn(1));
        AbstractPurchase purchaseThree = new PercentDiscountPurchase(product, 3, 20.0);
        AbstractPurchase purchaseFore = new TransportExpensesPurchase(product, 8);

        //purchase with cost 5 is in the middle
        AbstractPurchase[] middleSet = {purchaseFore, purchaseThree, key, purchaseOne};
        assertEquals(2, PurchaseUtil.searchPurchase(middleSet));

        //purchase with cost 5 is the end
        AbstractPurchase[] endSet = {purchaseFore, purchaseThree, key};
        assertEquals(2, PurchaseUtil.searchPurchase(endSet));

        //purchase with cost 5 is the beginning
        AbstractPurchase[] beginningSet = {key, purchaseTwo, purchaseOne};
        assertEquals(0, PurchaseUtil.searchPurchase(beginningSet));

        //purchase with cost 5 is the biggest
        AbstractPurchase[] keyIsBiggerSet = {purchaseOne, purchaseTwo};
        assertEquals(-1, PurchaseUtil.searchPurchase(keyIsBiggerSet));

        //purchase with cost 5 is the smallest
        AbstractPurchase[] keyIsSmallerSet = {purchaseThree, purchaseFore};
        assertEquals(-3, PurchaseUtil.searchPurchase(keyIsSmallerSet));
    }
}