package by.epam.lab;

public class TransportExpensesPurchase extends AbstractPurchase{
    private final static Byn EXPENSES = new Byn(500);

    public TransportExpensesPurchase(){
    }

    public TransportExpensesPurchase(Product product, int number) {
        super(product, number);
    }

    @Override
    public Byn getCost() {
        return super.getCost().add(EXPENSES);
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        //Inverse compare for decreasing sort
        return o.getCost().compareTo(getCost());
    }

    @Override
    public String fieldsToString(){
        return String.format("%s;%s", super.fieldsToString(), EXPENSES);
    }
}
