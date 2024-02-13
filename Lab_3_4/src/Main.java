import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create an address
        Address address = new Address(123, "New York", "Wall Street");

        // Create a client
        Client client = new Client("John Doe", LocalDate.of(1980, 1, 1), "1234567890123", address);

        // Create a debit account and a credit account
        DebitAccount debitAccount = new DebitAccount("DE1234567890");
        CreditAccount creditAccount = new CreditAccount("CR1234567890", 5000);

        // Deposit some money into the accounts
        debitAccount.deposit(1000);
        creditAccount.deposit(2000);

        // Add the accounts to the client
        client.addAccount(debitAccount);
        client.addAccount(creditAccount);

        // Print the client details
        System.out.println(client);

        // Try to withdraw money from the debit account
        boolean debitWithdraw = debitAccount.withdraw(500);
        System.out.println("Debit account withdrawal successful: " + debitWithdraw);

        // Try to withdraw money from the credit account
        boolean creditWithdraw = creditAccount.withdraw(2500);
        System.out.println("Credit account withdrawal successful: " + creditWithdraw);

        // Try to remove the debit account
        boolean debitRemove = client.removeAccount(debitAccount.getIban());
        System.out.println("Debit account removal successful: " + debitRemove);

        // Print the client details
        System.out.println(client);

        // Create some Person objects
        Person person1 = new Person("John", LocalDate.of(1980, 1, 1), "Male", 180);
        Person person2 = new Person("John", LocalDate.of(1985, 2, 12), "Male", 185);
        Person person3 = new Person("Jane", LocalDate.of(1985, 1, 1), "Female", 170);
        Person person4 = new Person("Jane", LocalDate.of(1985, 1, 1), "Female", 160);
        Person person5 = new Person("Jane", LocalDate.of(1985, 1, 1), "Female", 160);

        // Test the compareTo method for persons with same name
        System.out.println(person1.compareTo(person2));
        // Test the compareTo method for persons with different name
        System.out.println(person2.compareTo(person3));
        // Height compare
        System.out.println(person4.compareTo(person3));
        // Same person comparison
        System.out.println(person4.compareTo(person5));

        // Test the store method
        person1.store("person1.txt");
        person2.store("person2.txt");
        person3.store("person3.txt");
    }
}