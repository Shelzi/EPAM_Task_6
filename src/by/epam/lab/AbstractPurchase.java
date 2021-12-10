package by.epam.lab;

import com.sun.xml.internal.bind.v2.TODO;

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

    public Byn getCost() {
        return product.getPrice().mul(number);
    }

    //public abstract Byn specialCost();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPurchase that = (AbstractPurchase) o;
        return number == that.number && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, number);
    }

    @Override
    public abstract int compareTo(AbstractPurchase o);

    public String fieldsToString() {    // TODO: fix fieldsToString() overriding in child classes, not properly working
        return String.format("%s;%s",
                product, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;",
                fieldsToString(), getCost());
    }
}