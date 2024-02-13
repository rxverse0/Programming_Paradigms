import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;

    private LocalDate bday;

    private String CNP;

    private Address address;

    private List<Account> accounts = new ArrayList<>();


    public Client(String name, LocalDate bday, String CNP, Address address) {

        this.name = name;

        this.bday = bday;

        this.CNP = CNP;

        this.address = address;

    }

    public void addAccount(Account a) {

        accounts.add(a);

    }

    public boolean removeAccount(String i) {

        for (Account a : accounts)

            if (a.getIban().equals(i)) {

                accounts.remove(a);

                return true;

            }

        return false;

    }


    @Override

    public String toString() {

        return "Client{" +

                "name='" + name + '\'' +

                ", accounts=" + accounts +

                '}';

    }

}