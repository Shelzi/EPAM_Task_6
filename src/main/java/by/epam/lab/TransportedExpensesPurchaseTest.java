package by.epam.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransportedExpensesPurchaseTest {
    @Test
    public void getFinalCost() {
        Product milk = new Product("Milk", new Byn(500));
        TransportExpensesPurchase test = new TransportExpensesPurchase(milk, 6);
        assertEquals(new Byn(3500), test.getFinalCost(new Byn(3000)));
    }

    @Test
    public void getCost() {
        Product milk = new Product("Milk", new Byn(500));
        TransportExpensesPurchase test = new TransportExpensesPurchase(milk, 6);
        assertEquals(new Byn(3500), test.getCost());
    }
}