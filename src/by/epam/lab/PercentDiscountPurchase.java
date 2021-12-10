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
    public Byn getCost() {
        Byn tempCost = super.getCost();
        if (getNumber() >= AMOUNT_FOR_DISCOUNT) {
             tempCost = tempCost.mul((100 - discount) / 100, RoundMethod.FLOOR, 2);
        }
        return tempCost;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        //Inverse compare for decreasing sort
        return o.getCost().compareTo(getCost());
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
    public String fieldsToString(){
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}