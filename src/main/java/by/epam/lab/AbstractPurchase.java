package by.epam.lab;

import java.util.Objects;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private final int number;

    public AbstractPurchase() {
        product = new Product();
        number = 0;
    }

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    protected abstract Byn getFinalCost(Byn baseCost);

    public Byn getCost() {
        Byn baseCost = product.getPrice().mul(number);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, number);
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPurchase)) return false;
        AbstractPurchase purchase = (AbstractPurchase) o;
        return number == purchase.number && Objects.equals(product, purchase.product);
    }

    public String fieldsToString() {
        return String.format("%s;%s",
                product, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;",
                fieldsToString(), getCost());
    }
}