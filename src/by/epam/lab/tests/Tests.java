package by.epam.lab.tests;

import by.epam.lab.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void searchTest() {
        Product product = new Product("Milk", new Byn(500));

        AbstractPurchase key = new PriceDiscountPurchase(product, 1, new Byn()); // 5.00
        AbstractPurchase purchaseOne = new PriceDiscountPurchase(product, 1, new Byn(200)); //3.00
        AbstractPurchase purchaseTwo = new PriceDiscountPurchase(product, 1, new Byn(150)); //3.50
        AbstractPurchase purchaseThree = new PercentDiscountPurchase(product, 3, 20.0); //12.0
        AbstractPurchase purchaseFore = new TransportExpensesPurchase(product, 8); //45.0

        //purchase with cost 5 is in the middle
        AbstractPurchase[] firstSet = {purchaseOne, key, purchaseThree, purchaseFore};
        assertEquals(1, PurchaseUtil.searchPurchase(firstSet));

        //purchase with cost 5 is the start
        AbstractPurchase[] secondSet = {key, purchaseThree, purchaseFore};
        assertEquals(0, PurchaseUtil.searchPurchase(secondSet));     // TODO: need to fix fieldsToString() to understand why test is fail

        //purchase with cost 5 is the end
        AbstractPurchase[] thirdSet = {purchaseOne, purchaseTwo, key};
        assertEquals(2, PurchaseUtil.searchPurchase(thirdSet));

        //purchase with cost 5 is the biggest
        AbstractPurchase[] foreSet = {purchaseOne, purchaseTwo};
        assertEquals(-3, PurchaseUtil.searchPurchase(foreSet));

        //purchase with cost 5 is the smallest
        AbstractPurchase[] fiveSet = {purchaseThree, purchaseFore};
        assertEquals(-1, PurchaseUtil.searchPurchase(fiveSet));
    }
}