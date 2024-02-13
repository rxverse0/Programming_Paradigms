public class DebitAccount extends Account {


    public DebitAccount(String iban) {

        super(iban);

    }


    @Override

    public boolean withdraw(int sum) {

        if (this.amount >= sum) {

            amount -= sum;

            return true;

        }

        return false;


    }

}