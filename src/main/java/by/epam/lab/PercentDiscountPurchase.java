package by.epam.lab;

import java.util.Objects;

public class PercentDiscountPurchase extends AbstractPurchase {
    public static final int AMOUNT_FOR_DISCOUNT = 3;
    public double discount;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(Product product, int number, double discount) {
        super(product, number);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        if (getNumber() >= AMOUNT_FOR_DISCOUNT) {
            baseCost = baseCost.mul((100 - discount) / 100, RoundMethod.FLOOR, 0);
        }
        return baseCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractPurchase)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PercentDiscountPurchase that = (PercentDiscountPurchase) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}