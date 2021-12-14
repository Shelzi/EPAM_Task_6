package by.epam.lab;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Product product = new Product("Milk", new Byn(1850));
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new PriceDiscountPurchase(product, 2, new Byn(30)),
                new PercentDiscountPurchase(product, 15, 10.0),
                new PercentDiscountPurchase(product, 15, 12.2),
                new TransportExpensesPurchase(product, 5, new Byn(500)),
                new TransportExpensesPurchase(product, 5, new Byn(500)),
                new PriceDiscountPurchase(product, 1, new Byn(1350))
        };
        PurchaseUtil.printPurchases(purchases);
        Arrays.sort(purchases);
        PurchaseUtil.printPurchases(purchases);
        System.out.printf("Minimum cost = %s%n", purchases[purchases.length - 1].getCost());
        int searchIndex = PurchaseUtil.searchPurchase(purchases);
        if (searchIndex > -1) {
            System.out.printf("Purchase with cost 5.00 BYN = %s%n", purchases[searchIndex]);
        } else {
            System.out.println("No purchase with cost 5.00 BYN");
        }
        System.out.println(purchases[2].equals(purchases[3 ]));
    }
}