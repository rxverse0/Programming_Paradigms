public abstract class Account implements Comparable<Account> {

    private String iban;

    protected int amount;


    public Account(String iban) {

        this.iban = iban;

    }


    public String getIban() {

        return iban;

    }


    public void deposit(int sum) {

        if (sum < 0)

            throw new IllegalArgumentException("sum <0");

        amount += sum;

    }


    public abstract boolean withdraw(int sum);


    @Override

    public String toString() {

        return "Account{" +

                "iban='" + iban + '\'' +

                ", amount=" + amount +

                '}';

    }

    @Override
    public int compareTo(Account other) {
        if (this == other) return 0;
        if (this.amount != other.amount)
            return this.amount - other.amount;
        return this.iban.compareTo(other.iban);
    }

}

