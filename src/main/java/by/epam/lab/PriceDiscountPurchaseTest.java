package by.epam.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceDiscountPurchaseTest {
    @Test
    public void getFinalCost() {
        Product product = new Product("Milk", new Byn(500));
        PriceDiscountPurchase test = new PriceDiscountPurchase(product, 7, new Byn(150));
        assertEquals(new Byn(2450), test.getFinalCost(new Byn(3500)));
    }

    @Test
    public void getCost() {
        Product product = new Product("Milk", new Byn(500));
        PriceDiscountPurchase test = new PriceDiscountPurchase(product, 7, new Byn(150));
        assertEquals(new Byn(2400), test.getCost());
    }
}
