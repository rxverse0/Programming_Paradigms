/* Design questions:
Which is the shared resource?
The shared resource in this code is the Kitchen class.
It is shared among multiple Cook and Waiter threads.

What methods are synchronized?
In the Kitchen class:
-"public synchronized void addPizza(Pizza pizza)"
-"public synchronized Pizza removePizza() throws InterruptedException"

How can you ensure that Pizzas have unique ids?
Unique IDs for pizzas are ensured through the use of
a static variable nextId in the Pizza class:private static int nextId = 1;
Each time a new Pizza object is created, its ID is set to the current value of nextId,
and then nextId is incremented.
This ensures that each pizza has a unique ID within the scope of the program execution.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Pizza {
    private static int nextId = 1;

    private int id;
    private int numberOfIngredients;

    public Pizza(int numberOfIngredients) {
        this.id = nextId++;
        this.numberOfIngredients = numberOfIngredients;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }
}

class Kitchen {
    private Queue<Pizza> pizzas = new LinkedList<>();

    public synchronized void addPizza(Pizza pizza) {
        pizzas.offer(pizza);
        System.out.println("Pizza nr " + pizza.getId() + " was added");
        notifyAll();
    }

    public synchronized Pizza removePizza() throws InterruptedException {
        while (pizzas.isEmpty()) {
            wait();
        }
        Pizza pizza = pizzas.poll();
        System.out.println("Pizza nr " + pizza.getId() + " was removed");
        return pizza;
    }
}

class Cook extends Thread {
    private Kitchen kitchen;

    public Cook(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int numberOfIngredients = random.nextInt(5) + 3; // Random number of ingredients (3-7)
            Pizza pizza = new Pizza(numberOfIngredients);
            kitchen.addPizza(pizza);
            try {
                Thread.sleep(2000 * numberOfIngredients + 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Waiter extends Thread {
    private Kitchen kitchen;

    public Waiter(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Pizza pizza = kitchen.removePizza();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PizzaRestaurant {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        for (int i = 0; i < 3; i++) {
            Cook cook = new Cook(kitchen);
            cook.start();
        }

        for (int i = 0; i < 4; i++) {
            Waiter waiter = new Waiter(kitchen);
            waiter.start();
        }
    }
}
