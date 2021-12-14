package by.epam.lab;

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
    public String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), expenses);
    }
}