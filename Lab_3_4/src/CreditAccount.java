public class CreditAccount extends Account {

    private int maxCredit;


    public CreditAccount(String iban, int maxCredit) {

        super(iban);

        this.maxCredit = maxCredit;

    }


    @Override

    public boolean withdraw(int sum) {

        if (this.amount + maxCredit >= sum) {

            amount -= sum;

            return true;

        }

        return false;


    }

}