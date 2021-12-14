package by.epam.lab;

import java.util.Objects;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn expenses;

    public TransportExpensesPurchase() {
    }

    public TransportExpensesPurchase(Product product, int number, Byn expenses) {
        super(product, number);
        this.expenses = expenses;
    }

    public Byn getExpenses() {
        return expenses;
    }

    public void setExpenses(Byn expenses) {
        this.expenses = expenses;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.add(expenses);
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
        TransportExpensesPurchase that = (TransportExpensesPurchase) o;
        return Objects.equals(expenses, that.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expenses);
    }

    @Override
    public String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), expenses);
    }
}