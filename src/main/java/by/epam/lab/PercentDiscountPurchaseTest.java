package by.epam.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentDiscountPurchaseTest {
    @Test
    public void getCost() {
        Product product = new Product("Milk", new Byn(500));
        PercentDiscountPurchase test = new PercentDiscountPurchase(product, 1, 10.5);
        assertEquals(new Byn(500), test.getCost());
    }

    @Test
    public void getFinalCost() {
        Product product = new Product("Milk", new Byn(500));
        PercentDiscountPurchase test = new PercentDiscountPurchase(product, 10, 27.4);
        assertEquals(new Byn(3630), test.getFinalCost(new Byn(5000)));
    }
}
