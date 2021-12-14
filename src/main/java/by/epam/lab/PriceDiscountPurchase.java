package by.epam.lab;

import java.util.Objects;

public class PriceDiscountPurchase extends AbstractPurchase {
    public Byn discount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = discount;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.sub(discount.mul(getNumber()));
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
        PriceDiscountPurchase that = (PriceDiscountPurchase) o;
        return Objects.equals(discount, that.discount);
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