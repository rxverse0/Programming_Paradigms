///* Synchronized blocks instead of synchronized methods. */
//
// import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Random;
//
//class Pizza {
//    private static int nextId = 1;
//
//    private int id;
//    private int numberOfIngredients;
//
//    public Pizza(int numberOfIngredients) {
//        this.id = nextId++;
//        this.numberOfIngredients = numberOfIngredients;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getNumberOfIngredients() {
//        return numberOfIngredients;
//    }
//}
//
//class Kitchen {
//    private Queue<Pizza> pizzas = new LinkedList<>();
//    private final Object lock = new Object();
//
//    public void addPizza(Pizza pizza) {
//        synchronized (lock) {
//            pizzas.offer(pizza);
//            System.out.println("Pizza nr " + pizza.getId() + " was added");
//            lock.notifyAll();
//        }
//    }
//
//    public Pizza removePizza() throws InterruptedException {
//        synchronized (lock) {
//            while (pizzas.isEmpty()) {
//                lock.wait();
//            }
//            Pizza pizza = pizzas.poll();
//            System.out.println("Pizza nr " + pizza.getId() + " was removed");
//            return pizza;
//        }
//    }
//}
//
//class Cook extends Thread {
//    private Kitchen kitchen;
//
//    public Cook(Kitchen kitchen) {
//        this.kitchen = kitchen;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        while (true) {
//            int numberOfIngredients = random.nextInt(5) + 3; // Random number of ingredients (3-7)
//            Pizza pizza = new Pizza(numberOfIngredients);
//            kitchen.addPizza(pizza);
//            try {
//                Thread.sleep(5 + numberOfIngredients * 2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class Waiter extends Thread {
//    private Kitchen kitchen;
//
//    public Waiter(Kitchen kitchen) {
//        this.kitchen = kitchen;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Pizza pizza = kitchen.removePizza();
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//public class PizzaRestaurant2 {
//    public static void main(String[] args) {
//        Kitchen kitchen = new Kitchen();
//
//        for (int i = 0; i < 3; i++) {
//            Cook cook = new Cook(kitchen);
//            cook.start();
//        }
//
//        for (int i = 0; i < 4; i++) {
//            Waiter waiter = new Waiter(kitchen);
//            waiter.start();
//        }
//    }
//}
