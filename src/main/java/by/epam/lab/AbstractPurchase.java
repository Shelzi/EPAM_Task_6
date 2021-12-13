package by.epam.lab;

import java.util.Objects;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int number;


    public AbstractPurchase() {
        product = new Product();
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

    public void setNumber(int number) {
        this.number = number;
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
        return getCost().compareTo(o.getCost());
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