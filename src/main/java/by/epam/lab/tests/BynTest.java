package by.epam.lab.tests;

import by.epam.lab.Byn;
import by.epam.lab.Product;
import by.epam.lab.RoundMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class BynTest {
    @Test
    public void multiplyOnDoubleTest() {
        Byn expected = new Byn(700);
        Product product = new Product("Milk", new Byn(500));
        Byn actual = product.getPrice().mul(1.5, RoundMethod.FLOOR, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void addTest() {
        Byn expected = new Byn(700);
        Product product = new Product("Milk", new Byn(500));
        Byn actual = product.getPrice().add(new Byn(200));
        assertEquals(expected, actual);
    }

    @Test
    public void subTest() {
        Byn expected = new Byn(500);
        Product product = new Product("Milk", new Byn(700));
        Byn actual = product.getPrice().sub(new Byn(200));
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyOnIntTest() {
        Byn expected = new Byn(1000);
        Product product = new Product("Milk", new Byn(500));
        Byn actual = product.getPrice().mul(2);
        assertEquals(expected, actual);
    }
}