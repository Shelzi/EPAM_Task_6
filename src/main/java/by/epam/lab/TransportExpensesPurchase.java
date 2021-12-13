package by.epam.lab;

public class TransportExpensesPurchase extends AbstractPurchase {
    private final static Byn EXPENSES = new Byn(500);

    public TransportExpensesPurchase() {
    }

    public TransportExpensesPurchase(Product product, int number) {
        super(product, number);
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.add(EXPENSES);
    }

    @Override
    public String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), EXPENSES);
    }
}