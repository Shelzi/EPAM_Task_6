package by.epam.lab;

import java.util.Arrays;

public class PurchaseUtil {
    private PurchaseUtil() {
    }

    public static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
        System.out.println();
    }

    public static int searchPurchase(AbstractPurchase[] purchases) {
        AbstractPurchase key = new PriceDiscountPurchase((new Product("", new Byn(500))), 1, new Byn());
        return Arrays.binarySearch(purchases, key);
    }
}